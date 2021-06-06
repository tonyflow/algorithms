package leetcode;

import java.util.*;

public class MergeIntervals {

    static int[][] merge2(int[][] intervals) {
        // Compare starting dates
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        int[] reference = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // If the start of the next interval is smaller or equal
            // to the end of the previous one then merge the two
            if (intervals[i][0] <= reference[1]) {
                reference[1] = Math.max(reference[1], intervals[i][1]);
            } else {
                result.add(reference);
                reference = intervals[i];
            }
        }
        result.add(reference);
        return result.toArray(new int[result.size()][]);
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                if (result.getLast()[1] >= interval[0]) {
                    result.getLast()[1] = interval[1];
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] test = new int[][]{
                {8, 10},
                {1, 3},
                {15, 18},
                {2, 6},
        };

        Arrays.asList(MergeIntervals.merge(test)).forEach(interval -> System.out.println(Arrays.toString(interval)));
        Arrays.asList(MergeIntervals.merge2(test)).forEach(interval -> System.out.println(Arrays.toString(interval)));
    }
}
