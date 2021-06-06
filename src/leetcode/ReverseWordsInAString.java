package leetcode;

public class ReverseWordsInAString {

    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            StringBuilder wordBuilder = new StringBuilder(word);
//            int start = 0;
//            int end = word.length() - 1;
//            while (start < end) {
//                char a = word.charAt(start);
//                char b = word.charAt(end);
//                wordBuilder.setCharAt(start,b);
//                wordBuilder.setCharAt(end,a);
//                start++;
//                end--;
//            }
            builder.append(wordBuilder.reverse());
            builder.append(" ");
        }

        return builder.toString().trim();
    }
}
