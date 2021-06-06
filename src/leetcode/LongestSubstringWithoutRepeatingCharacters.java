package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    static int getLongestSubstringWithoutRepeatingCharacters(String s) {
        //pwkwew
        int i = 0, j = 0;
        int max = 0;
        Set<Character> duplicates = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!duplicates.contains(s.charAt(j))) {
                duplicates.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                duplicates.remove(s.charAt(i++));
            }
            System.out.println("i=" + i + ",j=" + j);
        }

        return max;
    }

    public static void main(String[] args) {
        int max = LongestSubstringWithoutRepeatingCharacters.getLongestSubstringWithoutRepeatingCharacters("pawkew");

        System.out.println(max);
    }
}
