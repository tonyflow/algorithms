package leetcode;

public class MaximumAscendingSubarray {

    static int maxAscendingSum(int[] nums) {

        int max = Integer.MIN_VALUE;
        int runningSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                runningSum += nums[i];
            } else {
                max = Math.max(max, runningSum);
                runningSum = nums[i];
            }
        }

        return Math.max(max, runningSum);
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }
}
