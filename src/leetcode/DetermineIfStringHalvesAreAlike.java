package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        for (Character c : new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            vowels.add(c);
        }
        int vowelCountsA = 0;
        int vowelCountsB = 0;

        for (int i = 0, j = s.length() / 2; i < s.length() / 2 && j < s.length(); i++, j++) {
            if (vowels.contains(s.charAt(i))) vowelCountsA++;
            if (vowels.contains(s.charAt(j))) vowelCountsB++;

        }

        return vowelCountsA == vowelCountsB;

    }
}
