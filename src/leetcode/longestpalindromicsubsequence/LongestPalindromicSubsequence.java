package leetcode.longestpalindromicsubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

//    int max = 1;

    public int longestPalindromicSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int[] memos : memo) {
            Arrays.fill(memos, -1);
        }
        return find(s, 0, s.length() - 1, memo);
    }

    private int find(String s,
                     int start,
                     int end,
                     int[][] memo) {
        if (start < end) {
            if (memo[start][end] == -1) {
                if (s.charAt(start) == s.charAt(end)) {
                    memo[start][end] = 2 + find(s, start + 1, end - 1, memo);
                } else {
                    memo[start][end] = Math.max(find(s, start + 1, end, memo), find(s, start, end - 1, memo));
                }
            }
            return memo[start][end];
        } else if (start == end) {
            return 1;
        } else return 0;
    }

    private boolean isPalindromic(StringBuilder s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    // This is an unsuccessful try for tabulation
    public int tabulation(String s) {
        // Longest subsequence starting from i and ending at j
        // +1 in order to accommodate cases where i start at 0
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }

        int result = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i + 1; j < dp[0].length - 1; j++) {
                char start = s.charAt(i - 1);
                char end = s.charAt(j - 1);
                if (start == end) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return result;
    }


}
