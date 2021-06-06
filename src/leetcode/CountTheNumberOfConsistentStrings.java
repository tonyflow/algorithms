package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {

    // No hash set needed here
    public int count(String allowed, String[] words) {
        int countOfAllowedWords = 0;
        for (String word : words) {
            boolean isValid = true;
            for (char c : word.toCharArray()) {
                if (!allowed.contains(Character.toString(c))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) countOfAllowedWords++;
        }
        return countOfAllowedWords;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedChars = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedChars.add(c);
        }

        int countOfAllowedWords = 0;
        for (String word : words) {
            if (isAllowed(word, allowedChars)) countOfAllowedWords++;
        }

        return countOfAllowedWords;
    }

    private boolean isAllowed(String s, Set<Character> allowed) {
        for (char c : s.toCharArray()) {
            if (!allowed.contains(c)) return false;
        }
        return true;
    }
}
