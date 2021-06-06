package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProductOfThreeNumbers {

    /**
     * There must also be a solution with O(n)...
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int endOrStart = Math.max(nums[0] * nums[1] * nums[2], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        int oneStartTwoEndTwoStartOneEnd = Math.max(nums[0]*nums[nums.length - 1] * nums[nums.length - 2],nums[0]*nums[1]*nums[nums.length - 1]);
        return Math.max(endOrStart,oneStartTwoEndTwoStartOneEnd);
    }

    // The numbers are not contiguous - this is wrong
    public int contiguous(int[] nums) {
        int start = 0;
        int end = start + 3;
        int max = Integer.MIN_VALUE;
        while (end <= nums.length) {
            int product = 1;
            for (int i = start; i < end; i++) {
                product *= nums[i];
            }
            max = Math.max(product, max);
            start++;
            end++;
        }
        return max;
    }

    /**
     * Cannot use this approach because the problem does not allow subarrays of length one
     */
    public int maxProductSubarray(int[] nums) {
        int max = 1;
        int min = 1;
        for (int num : nums) {
            if (num == 0) {
                max = 1;
                min = 1;
            }
            int tmp = max;
            max = Math.max(max * num, Math.max(min * num, num));
            min = Math.min(tmp * num, Math.max(min * num, num));
        }

        return Math.max(max, min);
    }
}
