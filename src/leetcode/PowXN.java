package leetcode;

public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return powPositive(x, n);
        } else {
            return 1 / powPositive(x, Math.abs(n));
        }

    }

    private double powPositive(double x, int n) {
        if (n == 0) return 1;
        return x / powPositive(x, n - 1);
    }
}
