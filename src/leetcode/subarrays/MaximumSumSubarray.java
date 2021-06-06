package leetcode.subarrays;

public class MaximumSumSubarray {

    /**
     * Kadane naive is exactly the same as the brute force approach
     */

    static int kadaneNaive(int[] nums) {
        int maxLocal = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(nums[i], maxLocal + nums[i]);
            max = Math.max(maxLocal, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(kadaneNaive(new int[]{-2, 3, 2, -1}));
    }
}
