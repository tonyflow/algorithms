package leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BestTimeToByAndSellStockIII {

    /**
     * This man is god
     * - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     */
    public int maxProfit(int[] prices) {

        /*
        The max profit before day 0 with at most 1 transaction while having 0 stocks at the end of the day is 0
         */
        int profit_i10 = 0;

        /*
        The max profit before day 0 with at most 1 transaction while having 1 stocks at the end of the day is MIN_VALUE
        because this scenario is impossible. We cannot have a stock at hand until we start traversing the array
         */
        int profit_i11 = Integer.MIN_VALUE;

        /*
        The max profit before day 0 with at most 2 transactions while having 0 stocks at the end of the day is 0. We could
        just be resting...
         */
        int profit_i20 = 0;

        /*
        The max profit before day 0 with at most 2 transactions while having 1 stocks at the end of the day is MIN_VALUE
        because this scenario is impossible. We cannot have a stock at hand until we start traversing the array
         */
        int profit_i21 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            profit_i10 = Math.max(profit_i10, profit_i11 + prices[i]);
            profit_i11 = Math.max(profit_i11, 0 - prices[i]); // profit[i - 1][0][0] = 0 always
            profit_i20 = Math.max(profit_i20, profit_i21 + prices[i]);
            profit_i21 = Math.max(profit_i21, profit_i10 - prices[i]); // 2 - 1
        }

        return profit_i20;
    }

    /**
     * T[x][y][z] the maximum profit which can be achieved at the end of x day with at most k transactions
     *
     */
    public int generalizeToKTransactions(int[] prices) {
        int k = 2; // number of available transactions
        int s = 2; // number of stock we left with after completing a transactions at day i
        int[][][] profit = new int[prices.length][k][s + 1];
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            profit[i][k][0] = Math.max(profit[i - 1][k][0], profit[i - 1][k][1] + prices[i]); // the previous state can be rest or sell since we're left with 0 stock after i-th day
            profit[i][k][1] = Math.max(profit[i - 1][k][1], profit[i - 1][k - 1][0] - prices[i]);// the previous stay can be rest or buy since we're left with one stock after i-th day
            max = Math.max(profit[i][k][1], profit[i][k][0]);
        }
        return max;
    }

    // The solution below get a TLE bitches... although it tests positive for 201 / 214 test cases !!! Damn...
    public int tle(int[] prices) {

        Map<MemoElement, Integer> memo = new HashMap<>();
        return profit(prices, 0, false, 2, memo);
    }

    class MemoElement {
        int index;
        boolean canSell;
        int availableTransactions;

        public MemoElement(int index,
                           boolean canSell,
                           int availableTransactions) {
            this.index = index;
            this.canSell = canSell;
            this.availableTransactions = availableTransactions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoElement that = (MemoElement) o;
            return index == that.index && canSell == that.canSell && availableTransactions == that.availableTransactions;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, canSell, availableTransactions);
        }
    }

    private int profit(int[] prices,
                       int index,
                       boolean canSell,
                       int availableTransactions,
                       Map<MemoElement, Integer> memo) {
        if (availableTransactions == 0 || index == prices.length) return 0;

        MemoElement element = new MemoElement(index, canSell, availableTransactions);
        if (!memo.containsKey(element)) {
            if (canSell)
                return prices[index] + profit(prices, index + 1, false, availableTransactions - 1, memo);

            // we can buy
            int max = 0;
            for (int i = index; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    // we are buying at index i so -prices[i] plus the potential profit from future
                    max = Math.max(max, -prices[i] + profit(prices, j, true, availableTransactions, memo));
                }

            }

            memo.put(element, max);
        }

        return memo.get(element);
    }
}
