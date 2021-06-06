package leetcode;

public class PalindromeNumber {

    static boolean check2(int x) {
        int helper = x;
        int reversed = 0;
        while (helper > 0) {
            int lastDigit = helper % 10;
            reversed = reversed * 10 + lastDigit;
            helper /= 10;
        }

        return reversed == x;
    }

    static boolean check(int x) {

        int lastDigit = 0;
        int reversed = 0;
        while (x > reversed) {
            lastDigit = x % 10;
            reversed = (reversed * 10) + lastDigit;
            x /= 10;
        }
        return reversed == x || ((x * 10) + lastDigit == reversed);
    }

    public static void main(String[] args) {

//        System.out.println(check(12321));
        System.out.println(check2(11));
    }

}
