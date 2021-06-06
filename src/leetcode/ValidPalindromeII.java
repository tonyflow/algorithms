package leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ValidPalindromeII {

    static boolean validPalindrome(String s) {

        int allowedDeletions = 1;
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end] && allowedDeletions > 0) {
                // Check whether deleting the character at position start makes the string a palindrome
                int newStart = start + 1;
                int newEnd = end;
                boolean isPalindromeIfWeRemoveEnd = true;
                boolean isPalindromeIfWeRemoveStart = true;
                while (newStart < newEnd) {
                    if (chars[newStart] != chars[newEnd]) {
                        // Removing char at start does not make the string a palindrome
                        isPalindromeIfWeRemoveStart = false;
                    }
                    newStart++;
                    newEnd--;
                }

                // Check whether deleting the character at position end makes the string a palindrome
                newStart = start;
                newEnd = end - 1;
                while (newStart < newEnd) {
                    if (chars[newStart] != chars[newEnd]) {
                        // Removing char at end does not make the string a palindrome
                        isPalindromeIfWeRemoveEnd = false;
                    }
                    newStart++;
                    newEnd--;
                }

                return isPalindromeIfWeRemoveEnd || isPalindromeIfWeRemoveStart;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(validPalindrome("cbbcc"));
//        System.out.println(validPalindrome("abc"));
//        System.out.println(validPalindrome("tebbem"));
        System.out.println(validPalindrome("abca"));

    }
}
