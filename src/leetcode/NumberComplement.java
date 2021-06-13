package leetcode;

public class NumberComplement {

    public int findComplement(int num) {
        int one = 1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = one << i;
            int digit = num ^ mask;
            result += digit * Math.pow(2, i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
