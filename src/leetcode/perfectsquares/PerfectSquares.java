package leetcode.perfectsquares;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    public int dp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        if (n <= 3) return n;
        Map<Integer, Integer> memo = new HashMap<>();
        return sum(n, 0, 0, memo);
    }

    private int sum(int n,
                    int numOfSquares,
                    int accumulator,
                    Map<Integer, Integer> memo) {
        if (accumulator == n) {
            return numOfSquares;
        } else if (accumulator > n) {
            return Integer.MAX_VALUE;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                min = Math.min(min, sum(n, numOfSquares + 1, accumulator + i * i, memo));
            }
            return min;
//            if (!memo.containsKey(accumulator)) {
//                int min = Integer.MAX_VALUE;
//                for (int i = 1; i * i <= n; i++) {
//                    min = Math.min(min, sum(n, numOfSquares + 1, accumulator + i*i, memo));
//                }
//                memo.put(accumulator, min);
//            }
//            return memo.get(accumulator);
        }
    }
}
