package recap;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // abcabcbb
    static int findLengthOfLongest(String input) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> distinct = new HashSet<>();
        while (j < input.length()) {
            if (!distinct.contains(input.charAt(j))) {
                distinct.add(input.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                distinct.remove(input.charAt(i++));
            }
        }
        return max;
    }

    static int brute(String input) {
        String longest = "";
        int max = 1;
        for (int i = 0; i < input.length(); i++) {
            longest = Character.toString(input.charAt(i));
            for (int j = i + 1; j < input.length(); j++) {
                if (!longest.contains(Character.toString(input.charAt(j)))) {
                    longest += Character.toString(input.charAt(j));
                    if (longest.length() > max) max = longest.length();
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(brute("abcabcbb"));
        System.out.println(brute("bbbbbb"));
        System.out.println(brute("pwwkew"));

        System.out.println(findLengthOfLongest("abcabcbb"));
        System.out.println(findLengthOfLongest("bbbbbb"));
        System.out.println(findLengthOfLongest("pwwkew"));
    }
}
