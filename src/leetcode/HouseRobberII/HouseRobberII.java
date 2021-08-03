package leetcode.HouseRobberII;

import java.util.*;

public class HouseRobberII {

    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums,
                    int start,
                    int end) {
        if (end - start == 0) return nums[start];
        if (end - start == 1) return Math.max(nums[start], nums[end]);
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        return dp[dp.length - 1];
    }


}
