package leetcode.stringtointegeratoi;


import java.math.BigInteger;

public class StringToIntegerAtoi {

    static public int myAtoi(String s) {
        int current = 0;
        while (current < s.length() && s.charAt(current) == ' ') current++;

        boolean isPositive = true;

        if (current > s.length()) return 0;

        if (s.charAt(current) == '-') {
            isPositive = false;
            current++;
        } else if (s.charAt(current) == '+') {
            current++;
        }

        StringBuilder builder = new StringBuilder();
        while (current < s.length() && s.charAt(current) >= '0' && s.charAt(current) <= '9') {
            builder.append(s.charAt(current));
            current++;
        }

        if (builder.length() == 0) return 0;

        BigInteger number = new BigInteger(builder.toString());
        BigInteger helper = isPositive ? number : number.multiply(new BigInteger("-1"));

        if (helper.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) return Integer.MIN_VALUE;
        if (helper.compareTo(BigInteger.valueOf(Integer.MAX_VALUE - 1)) > 0) return Integer.MAX_VALUE - 1;

        return helper.intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));

    }
}
