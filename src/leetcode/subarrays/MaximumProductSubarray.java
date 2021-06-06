package leetcode.subarrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    /**
     * Can't really understand this solution
     */
    static int findLeetCodeSolution(int[] nums) {

        int max = Integer.MIN_VALUE;


        return max;
    }

    /**
     * This logic is similar to Kadane's logic for finding the max subarray sum
     */
    static int findExplanatorySolution(int[] nums) {
        int max = nums[0];
        int maxRunning = nums[0];
        int minRunning = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxRunning = 0;
                minRunning = 0;
            } else if (nums[i] > 0) {
                if (maxRunning > 0)
                    maxRunning *= nums[i];
                else {
                    // max running < 0
                    if (minRunning > 0) {
//                        maxRunning
                    }
                    maxRunning = nums[i];
                }

                if (minRunning > 0) {
                    // Do nothing - we do not want to increase a minimum
                } else {
                    minRunning *= nums[i];
                }
            } else {
                int tmp = maxRunning;
                // nums[i] < 0

                if (maxRunning > 0) {
                    // Do nothing = we do not want to decrease a maximum
                } else {
                    maxRunning = nums[i];
                }

                if (minRunning > 0) {
                    minRunning *= minRunning;
                } else {
//                    minRunning*=ma
                }
            }

            max = Math.max(max, Math.max(maxRunning, minRunning));
        }

        return max;
    }

    static int findKadane(int[] nums) {
        int maxRunning = nums[0];
        int minRunning = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = maxRunning;
            maxRunning = Math.max(nums[i], Math.max(minRunning * nums[i], maxRunning * nums[i]));
            minRunning = Math.min(nums[i], Math.min(minRunning * nums[i], tmp * nums[i]));
            max = Math.max(max, maxRunning);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println((findKadane(new int[]{2, 3, -2, 4})));
        System.out.println(findKadane(new int[]{-2, 0, -1}));
        System.out.println(findKadane(new int[]{-1, -2, -3, 4}));
    }
}
