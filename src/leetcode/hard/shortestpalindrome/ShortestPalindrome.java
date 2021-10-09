package leetcode.hard.shortestpalindrome;

import java.util.Arrays;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if (s.length() < 2) return s;
        String reversed = new StringBuilder(s).reverse().toString();
        String helper = reversed + "#" + s;
        int[] lps = constructPSArray(helper);
        System.out.println(Arrays.toString(lps));
        return reversed.substring(0, s.length() - lps[lps.length - 1]) + s;
    }

    private int[] constructPSArray(String s) {
        int[] ps = new int[s.length()];
        Arrays.fill(ps, 0);

        int left = 0;
        int right = 1;

        while (right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                ps[right] = left + 1;
                left++;
                right++;
            } else {
                if (left != 0) left = ps[left - 1];
                else right++;
            }
        }

        return ps;
    }

    public String brute(String s) {

        if (s.length() < 2) return s;
        if (isPalindrome(s)) return s;
        String result = null;

        // Append to the start
        // Start from n-1 to 0 and do not reverse
        StringBuilder appendToTheStartNonReversedBuilder = new StringBuilder(s);
        StringBuilder extension = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            StringBuilder candidate = extension.append(s.charAt(i));
            StringBuilder extended = appendToTheStartNonReversedBuilder.insert(0, candidate);
            if (isPalindrome(extended) && (result == null || extended.length() < result.length()))
                result = extended.toString();

            appendToTheStartNonReversedBuilder.delete(0, candidate.length());
        }

        return result;
    }

    private StringBuilder reverse(StringBuilder builder) {
        return builder.reverse();
    }

    private boolean isPalindrome(String s) {
        return isPalindrome(new StringBuilder(s));
    }

    private boolean isPalindrome(StringBuilder s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
