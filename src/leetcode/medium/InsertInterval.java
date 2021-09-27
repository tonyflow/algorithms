package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();

        int current = 0;
        // Add all intervals which end before the new interval start
        while (current < intervals.length && intervals[current][1] < newInterval[0]) result.add(intervals[current++]);

        // Merge intersecting intervals
        //[3,7],[8,9]
        // The condition here is: all the intervals which start before the new intervals ends
        // Since in the first condition we have traversed all the intervals which end before the new interval starts
        // here we have intervals[current][1] >= newInterval[0] - or in other words: intervals which end after the new
        // interval begins e.g. newInterval = [4,x] and interval = [y,7]
        // Now if we factor in the condition  intervals[current][0] < newInterval[1] which means intervals which start
        // before the new interval ends e.g. newInterval = [x,5] and interval = [1,y] we end up with this condition
        // intervals[current][0] < newInterval[1] && intervals[current][1] >= newInterval[0] e.g. newInterval = [4,8] and
        // interval = [7,10] which are obviously intersecting intervals
        while (current < intervals.length && intervals[current][0] <= newInterval[1]) {
            newInterval = new int[]{
                    Math.min(newInterval[0], intervals[current][0]),
                    Math.min(newInterval[1], intervals[current][1]),
            };
            current++;
        }
        result.add(newInterval);

        // Add the remaining
        while (current < intervals.length) result.add(intervals[current++]);

        // Convert to result
        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i][0] = result.get(i)[0];
            r[i][1] = result.get(i)[1];
        }

        return r;
    }


    /**
     * This is a working solution but the code makes me want to throw up out of my eyelids
     */
    public int[][] uglyCode(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> result = new ArrayList();
        int startNewInterval = newInterval[0];
        int endNewInterval = newInterval[1];
        int traverse = 0;
        boolean merged = false;
        while (traverse < intervals.length) {
            int start = intervals[traverse][0];
            int end = intervals[traverse][1];

            if ((startNewInterval >= start && startNewInterval <= end)
                    || (endNewInterval >= start && endNewInterval <= end)
                    || (startNewInterval <= start && endNewInterval >= end)) {
                merged = true;
                int mergedStart = Math.min(startNewInterval, start);
                if (endNewInterval > end) {
                    int helper = traverse + 1;
                    int mergedEnd = Math.max(end, endNewInterval);
                    while (helper < intervals.length &&
                            (mergedEnd >= intervals[helper][0] ||
                                    mergedEnd >= intervals[helper][1])) {
                        mergedEnd = Math.max(mergedEnd, intervals[helper][1]);
                        helper++;
                    }
                    result.add(new int[]{mergedStart, mergedEnd});
                    traverse = helper;

                } else {
                    result.add(new int[]{mergedStart, Math.max(end, endNewInterval)});
                    traverse++;
                }
                // start merging
            } else {
                result.add(intervals[traverse]);
                traverse++;
            }
        }

        // If there is no point of intersection then traverse the result array and put the interval in the right
        // position
        boolean added = false;
        if (!merged) {
            for (int i = 0; i < result.size() && !added; i++) {
                if (result.get(i)[0] > startNewInterval) {
                    result.add(i, newInterval);
                    added = true;
                }
            }
            if (!added) result.add(newInterval);
        }

        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i][0] = result.get(i)[0];
            r[i][1] = result.get(i)[1];
        }
        return r;
    }
}
