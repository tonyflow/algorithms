package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s.equals(t)) return s;

        /*
        Using boxed types here because for very large inputs comparison operations on ints might fail.
        For more information check:
        - https://stackoverflow.com/questions/3130311/weird-integer-boxing-in-java
        - https://stackoverflow.com/questions/3131136/integers-caching-in-java?noredirect=1&lq=1
         */
        Integer left = 0;
        Integer right = 0;

        String answer = "";
        Integer answerLength = Integer.MAX_VALUE;

        /*
        number of characters whose identity AND counts match in the current window. SO for example if t==aabcc
        and s=abaddcc the match would be equal to 3 only at the end of the s string where
        count(a) = 2
        count(b) = 1 and
        count(c) = 2
        count(d) = IRRELEVANT
         */
        int matches = 0;

        Map<Character, Integer> tCounts = count(t, 0, t.length() - 1);

        /*
        Number of matches that we should have so that the window contains t is some form
        */
        int desired = tCounts.keySet().size();

        /*
        Keeper of the counts of the current sliding window
         */
        Map<Character, Integer> slidingWindowCounts = new HashMap<>();

        while (right < s.length()) {
            char current = s.charAt(right);
            slidingWindowCounts.put(current, slidingWindowCounts.getOrDefault(current, 0) + 1);

            if (tCounts.containsKey(current) && tCounts.get(current).equals(slidingWindowCounts.get(current)))
                matches++;

            /*
            The following condition could be also interpreted as matches == tCounts.keySet().size(). So what does this mean:
            If the current window includes all characters from s AND their counts then we can start shrinking the window and see
            if the condition still stands - since we want to find the MINIMUM substring anywayzzz
             */
            if (matches == desired) {
                while (left <= right && matches == desired) {

                    // Check if we have found a smaller window containing the given string
                    if (Integer.valueOf(right - left + 1).compareTo(answerLength) < 0) {
                        answer = s.substring(left, right + 1);
                        answerLength = right - left + 1;
                    }
                    char shrinkingWindowCurrent = s.charAt(left);

                    // Adjust character counts in the current window
                    slidingWindowCounts.put(shrinkingWindowCurrent, slidingWindowCounts.get(shrinkingWindowCurrent) - 1);

                    // Check if the previous adjustment affects the number of matches
                    if (tCounts.containsKey(shrinkingWindowCurrent) && tCounts.get(shrinkingWindowCurrent) > slidingWindowCounts.get(shrinkingWindowCurrent))
                        matches--;

                    left++;
                }
            }
            right++;
        }

        return answer;
    }

    /**
     * TLEs on large inputs
     */
    public String brute(String s, String t) {

        String window = "";
        int minLength = Integer.MAX_VALUE;

        char[] sr = s.toCharArray();

        // Create point of reference set
        Map<Character, Integer> tcounts = count(t, 0, t.length() - 1);

        for (int i = 0; i < sr.length; i++) {
            for (int j = i; j < sr.length; j++) {

                // Create a set of all characters included in the substring
                Map<Character, Integer> helper = count(s, i, j);

                // This substring contains all characters
                if (helper.keySet().containsAll(tcounts.keySet())) {
                    boolean included = true;
                    for (Character c : tcounts.keySet()) {
                        included = included && helper.get(c) >= tcounts.get(c);
                    }
                    if (included && j - i + 1 < minLength) {
                        window = s.substring(i, j + 1);
                        minLength = j - i + 1;
                    }
                }
            }
        }

        return window;
    }

    private Map<Character, Integer> count(String s,
                                          int start,
                                          int end) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = start; i <= end; i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }
        return counts;
    }

}
