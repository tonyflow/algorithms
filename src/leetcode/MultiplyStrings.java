package leetcode;

public class MultiplyStrings {

    static public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[n + m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int product = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                result[i + j] += product / 10;
                result[i + j + 1] += product % 10;
            }
        }

        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int helper = result[i] + carry;
            result[i] = helper % 10;
            carry = helper / 10;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]);
        }

        // Remove leading zeroes
        while (builder.charAt(0) == '0' && builder.length() > 1)
            builder.delete(0, 1);

        return builder.toString();
    }
}
