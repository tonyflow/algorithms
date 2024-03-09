package februaryreset;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    String find(String s) {
        char[] r = s.toCharArray();
        // For strings with odd length

        String oddAnswer = "";
        for (int i = 0; i < r.length; i++) {
            int expander = 1;
            String oddLocalAnswer = Character.toString(r[i]);
            while (i - expander >= 0 && i + expander < r.length && r[i + expander] == r[i - expander]) {
                oddLocalAnswer = r[i + expander] + oddLocalAnswer + r[i - expander];
                expander++;
            }
            if (oddAnswer.length() < oddLocalAnswer.length()) {
                oddAnswer = oddLocalAnswer;
            }
        }

        // For strings with even length
        String evenAnswer = "";
        for (int i = 0; i < r.length; i++) {
            int expander = 0;
            String evenLocalAnswer = "";
            while (i - expander >= 0 && i + expander < r.length && r[i + expander] == r[i - expander]) {
                evenLocalAnswer = r[i + expander] + evenLocalAnswer + r[i - expander];
                expander++;
            }
            if (oddAnswer.length() < evenLocalAnswer.length()) {
                evenAnswer = evenLocalAnswer;
            }
        }

        return evenAnswer.length() > oddAnswer.length() ? evenAnswer : oddAnswer;
    }
}
