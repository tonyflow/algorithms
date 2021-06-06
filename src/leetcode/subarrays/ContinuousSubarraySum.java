package leetcode.subarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum {

    static boolean has(int nums[], int k) {

        if (nums == null || nums.length < 2) return false;

        // Since we're only talking about positive integers this is the only case where we can have a multiple of zero
        // as a sum of a subarray of length greater or equal to 2
        if (k == 0) {
            if (checkConsecutiveZeros(nums)) return true;
        }

        // at least two consecutive zeros
        // [0,0] in this case 0+0 = 0 = 0*k with a subarray length of 2 so this should always return true
        if (checkConsecutiveZeros(nums)) return true;

        // Sum to last index
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            if (runningSum % k == 0 && i > 0) return true;
            if (sums.containsKey(runningSum % k)) {
                if (i - sums.get(runningSum % k) > 1) {
                    return true;
                }
            }

            sums.put(runningSum % k, i);
        }

        return false;
    }

    private static boolean checkConsecutiveZeros(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(has(new int[]{23, 2, 4, 6, 7}, 6)); // true
//        System.out.println(has(new int[]{23, 2, 6, 4, 7}, 6)); // true
//        System.out.println(has(new int[]{23, 2, 6, 4, 7}, 13)); // false
//        System.out.println(has(new int[]{23, 2, 4, 6, 6}, 7)); // true
//        System.out.println(has(new int[]{0}, 1)); // false
        System.out.println(has(new int[]{1, 0}, 2)); // false
//        System.out.println(has(new int[]{0, 0}, 1)); // true
//        System.out.println(has(new int[]{0, 1, 0}, 1)); // true


    }
}
