package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] restWithStock = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] restWithoutStock = new int[prices.length];
        int n = prices.length - 1;

        buy[0] = -prices[0] - fee;
        restWithStock[0] = Integer.MIN_VALUE;
        sell[0] = Integer.MIN_VALUE;
        restWithoutStock[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(restWithoutStock[i - 1], sell[i - 1]) - prices[i] - fee;
            restWithStock[i] = Math.max(restWithStock[i - 1], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1], restWithStock[i - 1]) + prices[i];
            restWithoutStock[i] = Math.max(sell[i - 1], restWithoutStock[i - 1]);
        }

        return Math.max(buy[n], Math.max(restWithStock[n], Math.max(sell[n], restWithoutStock[n])));
    }

    class MemoKey {
        int index;
        boolean canBuy;
        int lastBuyingPrice;

        public MemoKey(int index, boolean canBuy, int lastBuyingPrice) {
            this.index = index;
            this.canBuy = canBuy;
            this.lastBuyingPrice = lastBuyingPrice;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoKey memoKey = (MemoKey) o;
            return index == memoKey.index && canBuy == memoKey.canBuy && lastBuyingPrice == memoKey.lastBuyingPrice;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, canBuy, lastBuyingPrice);
        }
    }

    public int tle(int[] prices, int fee) {
        Map<MemoKey, Integer> memo = new HashMap<>();
        return findMax(prices, fee, 0, true, 0, memo);
    }

    private int findMax(int[] prices,
                        int fee,
                        int index,
                        boolean canBuy,
                        int lastBuyingPrice,
                        Map<MemoKey, Integer> memo) {

        // base case
        if (index == prices.length) return 0;

        MemoKey key = new MemoKey(index, canBuy, lastBuyingPrice);
        if (!memo.containsKey(key)) {
            // if we have not bought a stock yet
            // buy current or
            // do not buy current;
            if (canBuy) {
                int buy = findMax(prices, fee, index + 1, false, prices[index], memo);
                int doNotBuy = findMax(prices, fee, index + 1, true, 0, memo);
                memo.put(key, Math.max(buy, doNotBuy));
                return memo.get(key);
            }

            // if we have bought a stock
            // if bought price is smaller than the price at the current index then
            // -- we could sell
            // -- or we could wait
            // if bought price is larger than the price at the current index then do not sell and continue
            if (lastBuyingPrice < prices[index]) {
                int sell = (prices[index] - lastBuyingPrice) - fee + findMax(prices, fee, index + 1, true, 0, memo);
                int doNotSell = findMax(prices, fee, index + 1, false, lastBuyingPrice, memo);
                memo.put(key, Math.max(sell, doNotSell));
            } else {
                memo.put(key, findMax(prices, fee, index + 1, false, lastBuyingPrice, memo));
            }
        }
        return memo.get(key);
    }


    private int nonMemoized(int[] prices,
                            int fee,
                            int index,
                            boolean canBuy,
                            int lastBuyingPrice) {

        // base case
        if (index == prices.length) return 0;

        // if we have not bought a stock yet
        // buy current or
        // do not buy current;
        if (canBuy) {
            int buy = nonMemoized(prices, fee, index + 1, false, prices[index]);
            int doNotBuy = nonMemoized(prices, fee, index + 1, true, 0);

            return Math.max(buy, doNotBuy);
        }

        // if we have bought a stock
        // if bought price is smaller than the price at the current index then
        // -- we could sell
        // -- or we could wait
        // if bought price is larger than the price at the current index then do not sell and continue
        if (lastBuyingPrice < prices[index]) {
            int sell = (prices[index] - lastBuyingPrice) - fee + nonMemoized(prices, fee, index + 1, true, 0);
            int doNotSell = nonMemoized(prices, fee, index + 1, false, lastBuyingPrice);
            return Math.max(sell, doNotSell);
        } else {
            return nonMemoized(prices, fee, index + 1, false, lastBuyingPrice);
        }
    }
}
