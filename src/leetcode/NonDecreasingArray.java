package leetcode;

import java.util.Arrays;

/**
 * This problem can be easily translated to the Longest increasing subsequence problem. If we find the longest
 * increasing subsequence we can subtract it from the length of the array. If the number of odd elements is greater
 * than one then we return true, otherwise we return false
 */
public class NonDecreasingArray {

    /**
     * WRONG
     */
    static boolean checkPossibility(int[] nums) {

        // Try to solve it greedily
        int a = 0;
        int b = 0;
        int deleted = 0;

        if (nums.length <= 2) return true;

        while (a < nums.length - 2) {
            if (nums[a] <= nums[a + 1] && nums[a + 1] <= nums[a + 2]) {
                a++;
            } else if (nums[a] > nums[a + 1] && nums[a + 1] <= nums[a + 2]) {
                // skip current number
                a++;
                // increase the number of deleted
                deleted++;
            } else if (nums[a] <= nums[a + 1] && nums[a + 1] > nums[a + 2]) {
                if (nums[a] <= nums[a + 2]) {
                    // skipping next from current number
                    a += 2;
                    // increase the number of deleted
                    deleted++;
                } else {
                    // skipping next from current number
                    a += 3;
                    // increase the number of deleted
                    deleted += 2;
                }
            } else {
                // numbers are in ascending order
                return false;
            }
        }

        // Check tail of the array
        while (a < nums.length - 1) {
            if (nums[a] > nums[a + 1]) deleted++;
            a++;
        }
        return deleted < 2;
    }

    /**
     * n^2
     */
    static boolean dp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Longest increasing subsequence
        int max = Arrays.stream(dp).max().getAsInt();

        return nums.length - max <= 1;
    }

    public static void main(String[] args) {
//        System.out.println(checkPossibility(new int[]{2, 3}));
//        System.out.println(checkPossibility(new int[]{4, 2, 1}));
//        System.out.println(checkPossibility(new int[]{4, 2, 3}));
//        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
//        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));

//        System.out.println(dp(new int[]{-1, 4, 2, 3}));
    }
}
