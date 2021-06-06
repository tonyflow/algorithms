package leetcode;

public class LongestPalindromicSubstring {

    // babad
    static String compute(String s) {

        char[] chars = s.toCharArray();

        // for odd input
        String answerOds = "";
        for (int i = 0; i < chars.length; i++) {
            int expander = 1;
            String answerOdsIteration = Character.toString(chars[i]);
            while (i - expander >= 0 && i + expander < chars.length && chars[i - expander] == chars[i + expander]) {
                answerOdsIteration = chars[i - expander] + answerOdsIteration + chars[i + expander];
                expander++;
            }
            if (answerOdsIteration.length() > answerOds.length()) answerOds = answerOdsIteration;
        }

        //for even strings
        String answerEvens = "";
        for (int i = 0; i < chars.length; i++) {
            int expander = 0;
            String answerEvensIteration = "";
            while (i - expander >= 0 && i + expander + 1 < chars.length && chars[i - expander] == chars[i + expander + 1]) {
                answerEvensIteration = chars[i - expander] + answerEvensIteration + chars[i + expander + 1];
                expander++;
            }
            if (answerEvensIteration.length() > answerOds.length()) answerOds = answerEvensIteration;
        }

        return answerOds.length() > answerEvens.length() ? answerOds : answerEvens;
//        return Math.max(answerEvens.length(),answerEvens.length());

    }

    static int length(String s) {
        return compute(s).length();
    }

    public static void main(String[] args) {
//        String longest = LongestPalindrome.compute("babad");
//        String longest = LongestPalindrome.compute("cbbd");
        System.out.println(length("abccccdd"));
        System.out.println(length("bbbab"));

//        System.out.println(longest);
    }
}
