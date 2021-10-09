package leetcode.hard.longestsubstringwithatmostkdistinctcharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters {

    int findLongestLength(String s, int k) {
        try {
            return findLongest(s, k).length();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * This runs on linear time
     */
    String findLongest(String s, int k) {
        Set<Character> distinct = new HashSet();
        for (char c : s.toCharArray()) distinct.add(c);

        // The number of distinct characters is less than the number requested thus we cannot create any valid
        // substrings
        if (distinct.size() < k) throw new IllegalArgumentException("Number of distinct characters smaller than k");

        distinct.clear();
        Map<Character, Integer> charToIndex = new HashMap();

        int cursor = 0;
        String result = "";
        StringBuilder partial = new StringBuilder();

        while (cursor < s.length()) {
            char cursorChar = s.charAt(cursor);
            if (distinct.size() < k || (distinct.size() == k && distinct.contains(cursorChar))
            ) {
                charToIndex.put(cursorChar, cursor);
                distinct.add(cursorChar);
                partial.append(cursorChar);
                cursor++;
            } else {
                // Otherwise, we need to reset our substring
                if (result.length() < partial.length()) {
                    result = partial.toString();
                }

                // Reset state
                // Delete the part of the answer till we have less than k characters in the distinct set
                char firstCharOfThePartialAnswer = partial.charAt(0);
                distinct.remove(firstCharOfThePartialAnswer);
                partial.delete(0, charToIndex.get(firstCharOfThePartialAnswer) + 1);
                charToIndex.remove(firstCharOfThePartialAnswer);
            }
        }

        if (result.length() < partial.length()) {
            result = partial.toString();
        }
        return result;
    }
}
