package leetcode.longestincreasingsubsequence;

import java.util.*;

public class LongestIncreasingSubsequence {

    int patienceSorting(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = -pile - 1;
            if (pile == piles.size()) piles.add(num);
            else piles.set(pile, num);
        }
        return piles.size();
    }

    static int logarithmic(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     * This gets accepted. It is a brute force approach using memoization
     */
    static int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, goDownTheRabbitHole(nums, memo, i));
        }

        return max;
    }

    private static int goDownTheRabbitHole(int[] nums,
                                           int[] memo,
                                           int start) {
        if (memo[start] != -1) {
            return memo[start];
        } else {
            int max = 1;
            if (start < nums.length) {
                for (int i = start + 1; i < nums.length; i++) {
                    if (nums[start] < nums[i]) {
                        max = Math.max(max, 1 + goDownTheRabbitHole(nums, memo, i));
                    }
                }
                memo[start] = max;
                return max;
            } else {
                memo[start] = 0;
                return 0;
            }
        }
    }

    /**
     * Using DP
     * https://www.youtube.com/watch?v=CE2b_-XfVDk
     */
    static int dynamic(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
//        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

//        System.out.println(dynamic(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(dynamic(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(dynamic(new int[]{7, 7, 7, 7, 7, 7, 7}));
//        System.out.println(dynamic(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

        System.out.println(logarithmic(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(logarithmic(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(logarithmic(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(logarithmic(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
//        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
