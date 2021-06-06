package leetcode.addbinary;

import java.math.BigInteger;

public class AddBinary {

    public String alternative(String a,
                              String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            sum += carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            builder.append(sum % 2);

            //Update carry
            carry = sum > 1 ? 1 : 0;

            // Update sum
            sum = 0;

            // Update pointers
            i--;
            j--;
        }

        if (carry > 0) builder.append(1);
        return builder.reverse().toString();
    }

    BigInteger twoRep = new BigInteger("2");

    public String addBinary2(String a,
                             String b) {

        BigInteger aInteger = convertToInt(a);
        BigInteger bInteger = convertToInt(b);

        return convertToBinaryString(aInteger.add(bInteger));
    }

    private String convertToBinaryString(BigInteger a) {
        StringBuilder builder = new StringBuilder();

        if (a == BigInteger.ZERO) {
            builder.append("0");
        } else {
            while (a.compareTo(BigInteger.ZERO) > 0) {
                builder.insert(0, a.mod(twoRep));
                a = a.divide(twoRep);
            }
        }

        return builder.toString();
    }

    private BigInteger convertToInt(String a) {
        BigInteger total = BigInteger.ZERO;
        int magnitude = 0;
        for (int i = a.toCharArray().length - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                total = total.add(new BigInteger("2").pow(magnitude));
            }
            magnitude++;
        }
        return total;
    }

}
