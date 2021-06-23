package leetcode.decodeways;

import java.util.Arrays;

public class DecodeWays {

    public int dp(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        // dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i] + dp[i - 1];
        }

        return dp[s.length() - 1];
    }

    int ways = 0;

    public int numDecodings(String s) {
        doDecode(s, 0);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return ways;
    }

    // "2264245367245623253452637675789924563256457897362565234226424536724562325345263767578992456325645789"
    // It works using a global counter but it's difficult to introduce memoization in this one
    private void doDecode(String original, int index) {
        if (index == original.length()) {
            ways++;
        } else {
            if (index < original.length()) {
                // Go down the path using one digit
                String oneDigit = original.substring(index, index + 1);
                if (canContinue(oneDigit)) {
                    doDecode(original, index + 1);
                }
            }

            if (index + 1 < original.length()) {
                // Go down the path using two digits
                String twoDigits = original.substring(index, index + 2);
                if (canContinue(twoDigits)) {
                    doDecode(original, index + 2);
                }
            }
        }
    }

    public int decodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return bar(s, 0, memo);
    }

    /**
     * This introduces memoization by keeping the number of ways that we can decode the string at index i
     */
    private int bar(String original,
                    int index,
                    int[] memo) {
        if (index == original.length()) return 1;
        if (memo[index] != -1) return memo[index];
        if (original.charAt(index) == '0') return 0;
        int oneDigit = bar(original, index + 1, memo);
        int twoDigits = 0;
        if (index + 1 < original.length() && canContinue(original.substring(index, index + 2))) {
            twoDigits = bar(original, index + 2, memo);
        }

        memo[index] = oneDigit + twoDigits;
        return memo[index];
    }

    private int foo(String original, int index, int[] memo) {
        if (index == original.length()) {
            return 1;
        } else if (index + 1 < original.length()) {
            boolean oneDigitProcessing = canContinue(original.substring(index, index + 1)); // +1 because the right side is not inclusive
            boolean twoDigitsProcessing = canContinue(original.substring(index, index + 2)); // +2 because the right side is not inclusive
            if (oneDigitProcessing && twoDigitsProcessing) {
                if (memo[index] == -1) memo[index] = foo(original, index, memo);
                if (memo[index + 1] == -1) memo[index + 1] = foo(original, index + 1, memo);
                return memo[index] + memo[index + 1];
            } else if (oneDigitProcessing) {
                if (memo[index] == -1) memo[index] = foo(original, index, memo);
                return memo[index];
            } else if (twoDigitsProcessing) {
                if (memo[index + 1] == -1) memo[index + 1] = foo(original, index + 1, memo);
                return memo[index + 1];
            } else {
                return 0;
            }
        } else if (index < original.length()) {
            boolean oneDigitProcessing = canContinue(original.substring(index, index + 1));
            if (oneDigitProcessing) {
                if (memo[index] == -1) memo[index] = foo(original, index, memo);
                return memo[index];
            } else return 0;
        } else {
            return 0;
        }
    }

    private boolean canContinue(String stringRepresentation) {
        if (stringRepresentation.charAt(0) == '0') return false;
        if (Integer.parseInt(stringRepresentation) > 26) return false;
        return true;
    }
}
