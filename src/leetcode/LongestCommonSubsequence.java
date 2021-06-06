package leetcode;

import java.util.Arrays;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestCommonSubsequence.java
 */
public class LongestCommonSubsequence {

    static int longestCommonSubsequence(String text1, String text2) {

        int max = 0;
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 0; i < text1.toCharArray().length; i++) {
            for (int j = 0; j < text2.toCharArray().length; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else if (i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j - 1 >= 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        // We can also skip this since the initialization of dp already initializes all cells to 0
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
