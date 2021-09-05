package leetcode.medium;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1 || nums[0] == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return doj(nums, memo, 0);
    }

    private int doj(int[] nums, int[] memo, int index) {

        // Reached the end of the array
        if (index == nums.length - 1) return 0;

        // Exceeded the length of the array
        if (index > nums.length - 1) return Integer.MAX_VALUE;

        if (memo[index] == -1) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= nums[index]; i++) {
                int partial = doj(nums, memo, index + i);
                if (partial != Integer.MAX_VALUE)
                    min = Math.min(min, 1 + partial);
            }
            memo[index] = min;
        }
        return memo[index];
    }
}
