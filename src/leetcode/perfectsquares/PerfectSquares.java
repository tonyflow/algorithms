package leetcode.perfectsquares;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        if (n == 1) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            min = Math.min(min, sum(n, 1, new Double(Math.pow(i, 2)).intValue()));
        }

        return min;
    }

    public int sum(int n,
                   int numOfSquares,
                   int accumulator) {
        if (accumulator == n) {
            return numOfSquares;
        } else if (accumulator > n) {
            return Integer.MAX_VALUE;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n / 2; i++) {
                min = Math.min(min, sum(n, numOfSquares + 1, accumulator + new Double(Math.pow(i, 2)).intValue()));
            }
            return min;
        }
    }


}
