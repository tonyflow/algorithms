package leetcode.kweakestrowsinamatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRowsOptimal(int[][] mat, int k) {
        Comparator<CountPerIndex> comparator = Comparator.comparing(CountPerIndex::getSoldiers).thenComparing(CountPerIndex::getIndex);
        PriorityQueue<CountPerIndex> queue = new PriorityQueue<>(k, comparator);

        for (int i = 0; i < mat.length; i++) {
            int start = 0;
            int end = mat[i].length - 1;
            // Find where the 0 start
            // Subtract index from the total length to find number of 1
            // 1 1 0
            while (start < end) {
                int middle = (end - start) / 2 + start;
                if (mat[i][middle] == 0) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            if (mat[i][start] == 1) start++;
            queue.offer(new CountPerIndex(start, i));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=queue.poll().getIndex();
        }

        return result;
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        CountPerIndex[] soldierCountPerIndex = new CountPerIndex[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int start = 0;
            int end = mat[i].length - 1;
            // Find where the 0 start
            // Subtract index from the total length to find number of 1
            // 1 1 0
            while (start < end) {
                int middle = (end - start) / 2 + start;
                if (mat[i][middle] == 0) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            if (mat[i][start] == 1) start++;
            soldierCountPerIndex[i] = new CountPerIndex(start, i);
        }

        return Arrays.stream(soldierCountPerIndex)
                .sorted(Comparator.comparing(CountPerIndex::getSoldiers).thenComparing(CountPerIndex::getIndex))
                .mapToInt(soldierPerIndex -> soldierPerIndex.getIndex())
                .limit(k)
                .toArray();
    }

    class CountPerIndex {
        int soldiers;
        int index;

        public CountPerIndex(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        public int getSoldiers() {
            return this.soldiers;
        }

        public int getIndex() {
            return this.index;
        }
    }

}
