package leetcode.hard.besttimetobuyandsellstockiv;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][][] profit = new int[prices.length][k + 1][2];

        for (int transactions = 0; transactions <= k; transactions++) {
            // in order for a transaction to be profitable we need at least two days - one to buy and one to sell
            profit[0][transactions][0] = 0;

            // Having one stock at hand means we have bought one stock
            profit[0][transactions][1] = -prices[0];
        }

        // For zero transactions
        for (int day = 0; day < prices.length; day++) {
            // zero transactions = zero profit
            profit[day][0][0] = 0;

            // Having one stock at hand means we have bought one stock
            profit[day][0][1] = -prices[day];
        }

        for (int day = 1; day < prices.length; day++) {
            for (int transactions = 1; transactions <= k; transactions++) {
                profit[day][transactions][0] = Math.max(profit[day - 1][transactions][0], profit[day - 1][transactions][1] + prices[day]);
                profit[day][transactions][1] = Math.max(profit[day - 1][transactions][1], profit[day - 1][transactions - 1][0] - prices[day]);
            }
        }

        // we always have greater profit when we are left with zero stocks in hand
        return profit[prices.length - 1][k][0];
    }
}
