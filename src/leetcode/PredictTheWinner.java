package leetcode;

import java.util.Arrays;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], -1);
        return predict(nums, 0, nums.length - 1, 0, memo) >= 0;
    }

    private int predict(int[] nums,
                        int start,
                        int end,
                        int stintPlayer,
                        int[][] memo) {

        if (start > end) return 0;

        if (memo[start][end] == -1) {
            int takeFirst = nums[start] + predict(nums, start + 1, end, stintPlayer - 1, memo);
            int takeEnd = nums[end] + predict(nums, start, end - 1, stintPlayer - 1, memo);
            int max = Math.max(takeFirst, takeEnd);
            memo[start][end] = max;
        }


        if (stintPlayer == 0) {
            return memo[start][end];
        } else {
            return -memo[start][end];
        }
    }

}
