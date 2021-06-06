package leetcode.coinschange;

import java.util.*;

public class CoinChange {

    int dpBottomUpWithSortingOptimization(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * This approach tries to solve the problem by finding all the different combinations
     * of coins - it has a backtracking vibe to it.
     * It does solve the problem succesfully but due to the lack of memoization it does
     * TLE for leeetcode standards.
     *
     */
    int coinChange(int[] coins, int amount) {

        boolean[] used = new boolean[coins.length];

        ArrayList<Integer> tries = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            spend(coins, tries, used, amount, i, 0);
        }

        Collections.sort(tries);
        return tries.isEmpty() ? -1 : tries.get(0);
    }

    private void spend(int[] coins,
                       List<Integer> tries,
                       boolean[] usedMap,
                       int remainingAmount,
                       int index,
                       int totalCoinsUsedSoFar) {


        if (remainingAmount == 0) {
            tries.add(totalCoinsUsedSoFar);
        } else if (index >= 0 && index < coins.length) {
            usedMap[index] = true;
            int helper = remainingAmount / coins[index];

            for (int i = 0; i <= helper; i++) {

                // Search left
                for (int j = index - 1; j >= 0; j--) {
                    if (!usedMap[j]) {
                        spend(coins,
                                tries,
                                usedMap,
                                remainingAmount - i * coins[index],
                                j,
                                totalCoinsUsedSoFar + i);
                    }
                }

                // Search right
                for (int j = index + 1; j < coins.length; j++) {
                    if (!usedMap[j]) {
                        spend(coins,
                                tries,
                                usedMap,
                                remainingAmount - i * coins[index],
                                j,
                                totalCoinsUsedSoFar + i);
                    }
                }

                // If the two previous loops have not been executed then the denomination we're at is the last one
                spend(coins,
                        tries,
                        usedMap,
                        remainingAmount - i * coins[index],
                        Integer.MAX_VALUE,
                        totalCoinsUsedSoFar + i);
            }
            usedMap[index] = false;
        }
    }


    /**
     * Greedy approach - this is a dead end
     * Well, it's not a dead end but there are counter examples that prove
     * that this is not a general solution e.g. [1,3,4] and t=9
     */
    int greedy(int[] coins, int amount) {

        int[] sorted = Arrays.stream(coins)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int answer = 0;
        for (int denomination : sorted) {
            answer += amount / denomination;
            amount %= denomination;
        }
        return amount == 0 ? answer : -1;
    }

}
