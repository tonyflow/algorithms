package leetcode.subarrays;

import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class MaximumSizeSubarraySumEqualsK {

    static int find(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int runningSum = 0;
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (sums.containsKey(runningSum - k)) {
                max = Math.max(max, i - sums.get(runningSum - k));
            }
            sums.put(runningSum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{10, 5, 2, 7, 1, 9}, 15));
        System.out.println(find(new int[]{-5, 8, -14, 2, 4, 12}, -5));
    }
}
