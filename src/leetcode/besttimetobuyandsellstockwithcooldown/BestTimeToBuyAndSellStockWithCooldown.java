package leetcode.besttimetobuyandsellstockwithcooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BestTimeToBuyAndSellStockWithCooldown {

    class MemoElement {
        int index;
        int lastPriceIBoughtAt;
        boolean isCooldown;

        public MemoElement(int index,
                           int lastPriceIBoughtAt,
                           boolean isCooldown) {
            this.index = index;
            this.lastPriceIBoughtAt = lastPriceIBoughtAt;
            this.isCooldown = isCooldown;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoElement that = (MemoElement) o;
            return index == that.index && lastPriceIBoughtAt == that.lastPriceIBoughtAt && isCooldown == that.isCooldown;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, lastPriceIBoughtAt, isCooldown);
        }
    }

    public int maxProfit(int[] prices) {
        return find(prices, 0, -1, false, new HashMap<>());
    }

    private int find(int[] prices,
                     int index,
                     int lastPriceIBoughtAt,
                     boolean isCooldown,
                     Map<MemoElement, Integer> memo) {
        MemoElement memoElement = new MemoElement(index, lastPriceIBoughtAt, isCooldown);
        if (!memo.containsKey(memoElement)) {
            if (index == prices.length) return 0;
            else {
                if (isCooldown) {
                    memo.put(memoElement, find(prices, index + 1, lastPriceIBoughtAt, false, memo));
                } else {
                    if (lastPriceIBoughtAt == -1) {
                        // buy
                        memo.put(memoElement, find(prices, index + 1, prices[index], false, memo));
                    } else if (prices[index] > lastPriceIBoughtAt) {
                        int sell = prices[index] - lastPriceIBoughtAt + find(prices, index + 1, -1, true, memo);
                        int dontSell = find(prices, index + 1, lastPriceIBoughtAt, false, memo);
                        memo.put(memoElement, Math.max(sell, dontSell));
                    } else {
                        memo.put(memoElement, find(prices, index + 1, prices[index], false, memo));
                    }
                }
            }
        }
        return memo.get(memoElement);
    }
}
