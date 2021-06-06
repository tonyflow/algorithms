package leetcode;

public class ArrangingCoins {

    public int arrangeCoins(int n) {

        int maxRowCoins = 1;
        int numberOfCompleteRows = 0;
        while (n > 0) {
            // Incomplete row
            if (n / maxRowCoins == 0) {
                break;
            }
            n -= maxRowCoins;
            maxRowCoins++;
            numberOfCompleteRows++;
        }
        return numberOfCompleteRows;
    }

    /**
     * The problem is basically asking the maximum length of consecutive number that has the running sum lesser or equal
     * to `n`. In other word, find `x` that satisfy the following condition:
     *
     * `1 + 2 + 3 + 4 + 5 + 6 + 7 + ... + x <= n`
     * `sum_{i=1}^x i <= n`
     * Running sum can be simplified,
     *
     * `(x * ( x + 1)) / 2 <= n`
     * Using quadratic formula, `x` is evaluated to be,
     *
     * `x = 1 / 2 * (-sqrt(8 * n + 1)-1)` (Inapplicable) or `x = 1 / 2 * (sqrt(8 * n + 1)-1)`
     */
    public int arrangeCoins2(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
