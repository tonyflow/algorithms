package leetcode.hard.splitarraylongestsum;

import java.util.*;

public class SplitArrayLongestSum {

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int start = max;
        int end = sum;

        while (start < end) {
            int middle = start + end >>> 1;
            int pieces = findNOPieces(nums, middle);
            if (pieces > m) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }

    private int findNOPieces(int[] nums, int middle) {
        int sum = 0;
        int pieces = 1;
        for (int num : nums) {
            if (sum +num > middle) {
                sum = num;
                pieces++;
            } else {
                sum += num;
            }
        }
        return pieces;
    }

    /**
     * Top down with memoization will TLE
     */
    public int dp(int[] nums, int m) {
        int[][] memo = new int[nums.length][m + 1];
        int[] sums = new int[nums.length];
        for (int[] r : memo) Arrays.fill(r, -1);
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i];
        return split(nums, 0, m, sums, memo);
    }

    private int split(int nums[],
                      int index,
                      int m,
                      int[] sums,
                      int[][] memo) {

        if (m == 1)
            return sums[index];


        if (memo[index][m] == -1) {
            int min = Integer.MAX_VALUE;
            for (int i = index; i <= nums.length - m; i++) {
                int sum = 0;
                for (int j = index; j <= i; j++) sum += nums[j];
                min = Math.min(min, Math.max(sum, split(nums, i + 1, m - 1, sums, memo)));
            }

            memo[index][m] = min;
        }

        return memo[index][m];
    }
}
