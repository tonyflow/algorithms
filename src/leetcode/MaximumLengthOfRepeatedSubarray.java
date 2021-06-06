package leetcode;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {

    static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    static int findLengthBrute(int[] nums1, int[] nums2) {
        boolean[][] dp = new boolean[nums1.length][nums2.length];
        int max = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int currentMax = 0;
                    for (int k = i, l = j; k < nums1.length && l < nums2.length && nums1[k] == nums2[l]; k++, l++) {
                        currentMax = Math.max(currentMax, k - i + 1);
                    }
                    max = Math.max(max, currentMax);
                }
            }
//            for (int j = 0, k = i; j < nums2.length && k<nums1.length && nums1[k] == nums2[j]; j++, k++) {
//                currentMax++;
//            }
//            max = Math.max(max, currentMax);
        }

        return max;
    }

    private static int traverseDiagonally(boolean[][] dp, int max) {
        for (int i = 0; i < dp.length; i++) {
            int currentMax = 0;
            for (int j = 0, k = i; j < dp[i].length && k >= 0; j++, k--) {
                if (dp[k][j]) currentMax++;
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(findLengthBrute(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
//        System.out.println(findLengthBrute(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0}));

        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0}));

    }
}
