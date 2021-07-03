package leetcode;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

    static int countSubstrings(String s) {

        int count = 0;

        // For odd sized palindromic substrings
        for (int i = 0; i < s.length(); i++) {
            // Having as a center of expansion the character at i start expanding
            boolean isPalindrome = true;
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && isPalindrome) {
                if (s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                } else isPalindrome = false;
            }
        }

        // For even sized palindromic substrings
        for (int i = 0; i < s.length(); i++) {
            boolean isPalindrome = true;
            int start = i;
            int end = i + 1;
            while (start >= 0 && end < s.length() && isPalindrome) {
                if (s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                } else isPalindrome = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        countSubstrings("aaa");
    }
}
