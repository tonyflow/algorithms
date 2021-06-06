package leetcode;

public class BestTimeToBuyAndSellStockII {

    /**
     *
     */
    static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buyAt = 0;
        int sellAt = 1;
        while (sellAt < prices.length) {
            if (prices[buyAt] < prices[sellAt]) {
                totalProfit += prices[sellAt] - prices[buyAt];
            }
            sellAt++;
            buyAt++;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{1, 2, 3, 4, 5};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{2, 1, 2, 0, 1};
        System.out.println(maxProfit(prices));
    }
}
