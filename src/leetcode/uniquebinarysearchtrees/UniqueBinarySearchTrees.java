package leetcode.uniquebinarysearchtrees;

/**
 * This is just another description for the Catalan number computation
 */
public class UniqueBinarySearchTrees {

    static int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("dp[" + i + "] = " + dp[i] + " + dp[" + j + "-1] * dp[" + i + "-" + j + "] = " + dp[i] + " + dp[" + (j - 1) + "] * dp[" + (i - j) + "]");
                dp[i] += dp[j - 1] * dp[i - j];
//                dp[i] += dp[i - 1] * dp[n - i];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(numTrees(3));
        System.out.println(numTrees(6));
    }
}
