package leetcode.decodestring;

import java.util.Stack;

public class DecodeString {

    int index = 0;

    public String decodeString(String s) {
        return helper(s).toString();
    }

    private StringBuilder helper(String s) {

        int length = s.length();
        StringBuilder total = new StringBuilder();
        while (index < length) {
            StringBuilder repetitionFactorString = new StringBuilder();
            StringBuilder repeatedString = new StringBuilder();
            StringBuilder iterationResult = new StringBuilder();
            while (index < s.length() && s.charAt(index) >= 'a' && s.charAt(index) <= 'z')
                iterationResult.append(s.charAt(index++));
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9')
                repetitionFactorString.append(s.charAt(index++));
            if (index < s.length() && s.charAt(index) == '[') {
                index++;
                repeatedString = helper(s);
            }

            int repetition = repeatedString.toString().isEmpty() ? 0 : Integer.parseInt(repetitionFactorString.toString());

            for (int j = 0; j < repetition; j++) {
                iterationResult.append(repeatedString);
            }
            if (index < s.length() && s.charAt(index) == ']') {
                index++;
                return total.append(iterationResult);
            }
            total.append(iterationResult);
        }

        return total;

    }


}
