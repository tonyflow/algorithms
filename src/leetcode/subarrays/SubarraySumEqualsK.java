package leetcode.subarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {

    /**
     * Because of negative numbers this is a dead end solution. It works with positive only arrays very well though!
     */
    static int find(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int runningSum = 0;
        int totalNumOfSubarrays = 0;

        if (nums.length == 1 && nums[0] != k) return 0;

        while (end < nums.length) {
            runningSum += nums[end];
            if (runningSum == k) {
                totalNumOfSubarrays++;
                runningSum -= nums[start];
                start++;
            } else if (runningSum > k) {
                while (runningSum > k && start <= end) {
                    runningSum -= nums[start];
                    start++;
                    if (runningSum == k) {
                        totalNumOfSubarrays++;
                    }
                }
            } else if (runningSum < 0) {

            }
            end++;
        }

        while (start < nums.length) {
            runningSum -= nums[start];
            start++;
            if (runningSum == k) {
                totalNumOfSubarrays++;
            }
        }

        return totalNumOfSubarrays;
    }

    static int subarraySum(int[] nums, int k) {

        // Sum to frequency
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);

        int runningSum = 0;
        int totalNumOfSubarrays = 0;

        for (int num : nums) {
            runningSum += num;
            if (sums.containsKey(runningSum - k)) {
                totalNumOfSubarrays += sums.get(runningSum - k);
            }
            sums.put(runningSum, sums.getOrDefault(runningSum, 0) + 1);
        }

        return totalNumOfSubarrays;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(subarraySum(new int[]{0, 2, 2, 1, -1}, 4));
    }
}
