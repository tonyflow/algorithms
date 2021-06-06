package leetcode;

public class ReverseInteger {

    static int reverse(int n) {

        int reversed = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reversed = (reversed * 10) + lastDigit;
            if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
            n /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123456));
        System.out.println(reverse(120));
    }
}
