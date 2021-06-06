package leetcode.subarrays;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisibleByK {

    static int find(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int total = 0;

        int runningSum = 0;
        for (int num : nums) {
            runningSum += num;
            int remainder = runningSum % k;
            if (remainder < 0) remainder += k;
            if (sums.containsKey(remainder)) {
                total += sums.get(remainder);
            }
            sums.put(remainder, sums.getOrDefault(remainder, 0) + 1);
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{4, 5, 0, -2, -3, 1}, 5)); // 7
        System.out.println(find(new int[]{-1, 2, 9}, 2)); // 2
        System.out.println(find(new int[]{2, -2, 2, -4}, 6)); // 2
    }
}
