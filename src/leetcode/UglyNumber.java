package leetcode;

public class UglyNumber {

    static boolean isUgly(int n) {
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

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(1));
        System.out.println(isUgly(14));
    }
}
