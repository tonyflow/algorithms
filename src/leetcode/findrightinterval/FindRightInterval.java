package leetcode.findrightinterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class FindRightInterval {

    class Interval {
        int start;
        int end;
        int initialIndex;

        public Interval(int start,
                        int end) {
            this.start = start;
            this.end = end;
            this.initialIndex = 0;

        }

        public Interval(int start,
                        int end,
                        int initialIndex) {
            this.start = start;
            this.end = end;
            this.initialIndex = initialIndex;

        }

        int getStart() {
            return this.start;
        }
    }

    public int[] greatSolutionUsingTreeMap(int[][] intervals) {
        TreeMap<Integer, Integer> startToInitialIndex = new TreeMap<>();
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startToInitialIndex.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Integer potentialRightInterval = startToInitialIndex.ceilingKey(intervals[i][1]);
            result[i] = (potentialRightInterval != null ? startToInitialIndex.get(potentialRightInterval) : -1);
        }
        return result;
    }

    /**
     * Use BS
     */
    public int[] findRightInterval(int[][] intervals) {

        int[] result = new int[intervals.length];
        Interval[] sorted = new Interval[intervals.length];

        // Sort based on the start of the intervals - O(nlogn)
        for (int i = 0; i < intervals.length; i++) {
            sorted[i] = new Interval(intervals[i][0], intervals[i][1], i);
        }

        Arrays.sort(sorted, Comparator.comparing(Interval::getStart));

        for (int i = 0; i < sorted.length; i++) {
            int target = sorted[i].end;
            int start = i;
            int end = sorted.length - 1;

            while (start < end) {
                int middle = (start + end) >>> 1;
                if (sorted[middle].start >= target) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }

            if (start != sorted.length && sorted[start].start >= target) {
                result[sorted[i].initialIndex] = sorted[start].initialIndex;
            } else {
                result[sorted[i].initialIndex] = -1;
            }
        }
        return result;
    }
}
