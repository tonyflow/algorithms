package leetcode.uglynumberii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UglyNumberII {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        Set<Integer> processed = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int[] helper = {2 * dp[p2], 3 * dp[p3], 5 * dp[p5]};
            Arrays.sort(helper);
            for (int j = 0; j < helper.length; j++) {
                if (!processed.contains(helper[j])) {
                    dp[i] = helper[j];
                    break;
                }
            }

            if (dp[i] == 2 * dp[p2]) p2++;
            if (dp[i] == 3 * dp[p3]) p3++;
            if (dp[i] == 5 * dp[p5]) p5++;

        }
        return dp[n - 1];
    }

    public int tle(int n) {

        int number = 1;
        while (n > 0) {
            if (isUgly(number)) {
                System.out.println(number);
                n--;
            }
            number++;
        }
        return number;
    }

    private boolean isUgly(int n) {
        int[] factors = {2, 3, 5};
        if (n == 1) return true;
        int current = 0;
        while (n != 1 && current < factors.length) {
            int div = n / factors[current];
            int mod = n % factors[current];
            if (mod != 0) {
                current++;
            } else {
                n = div;
            }
        }

        return n == 1;
    }
}
