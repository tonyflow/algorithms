package leetcode.hard.palindromepartitioningii;

import java.util.Arrays;

public class PalindromePartitioningII {

    /**
     * Using recurrence relationship. The cut[i] represents the minimum number of cuts to make substring s(0,i) a palindrome
     * e.g. for string "aab" the initial state of cut would be [0,1,2] this makes sense if you think that for string
     * - s(0,0) "a" we need no cuts to make palindromic substrings
     * - s(0,1) "aa" we need 1 cuts to make palindromic substrings ("a","a") are palindromic substrings
     * - s(0,2) "aab" we need 2 cuts to make palindromic substrings ("a","a","b") are palindromic substrings
     * In principle in the beginning we have no idea about the structure of the string, so we assume that the partition
     * that cuts the string into palindrome substrings is the one breaking down the original string in its constituent
     * characters.
     *
     * Now we have two cases to traverse the cut/dp array
     * - One for even length strings and
     * - One for odd length strings
     * The rational though is the same for both. Let's explain how this works for odd numbered strings since our initial
     * example was "abb"
     *
     * For "aab" the initial state of the cut array is [0,1,2]. Now what we have to do is start from every character and
     * start expanding - with a left and right pointer - till we find a pair of characters that do not meet the criteria
     * for a palindromic sequence (the characters are different).
     *
     * Algorithm trace
     * - mid = 0
     *  - start = 0
     *  - end = 0
     *      - s.charAt(0) == s.charAt(0)
     *      - start = 0 => newCutAtEnd = 0
     *      - cut[0] = min(cut[0],0)
     * - mid = 1
     *  - start = 1
     *  - end = 1
     *      - s.charAt(1) == s.charAt(1)
     *      - start!=0 => newCutAtEnd = cut[1-1]+1 = 0+1. What this means is that the minimum number os cuts we need to
     *      maintain the palindromic property of the substring (I am saying here "to maintain" since we are checking
     *      inside the for loop the equality of the characters) is the minimum numbers of cuts the substring ending at
     *      start-1 needs plus 1 (+1). The plus one describes the cut if we were to cut the string at the current end.
     *      - cut[1] = min(cut[1],newCutAtEnd) = min(1,1) = 1
     *  - start = 0
     *  - end = 2
     *      - s.charAt(0) != s.charAt(2) => do not update anything
     * - mid = 2
     *  - start = 2
     *  - end = 2
     *      - s.charAt(2) == s.charAt(2)
     *      - start!=0 => newCutAtEnd = cut[2-1]+1 = cut[1]+1 = 2.
     *      - cut[2] = min(cut[2],newCutAtEnd) = min(1,2) = 1
     *
     * The result is on cut[s.length()-1] since this is the minimum number of cuts needed to partition s(0,s.length()) == original string
     * into palindromic substrings.
     *
     */
    public int minCut(String s) {
        int[] cut = new int[s.length()];

        for (int i = 0; i < cut.length; i++) {
            cut[i] = i;
        }

        for (int mid = 0; mid < s.length(); mid++) {
            // Odd number of characters
            for (int start = mid, end = mid; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : cut[start - 1] + 1;
                cut[end] = Math.min(cut[end], newCutAtEnd);
            }

            // Even number of characters
            for (int start = mid, end = mid + 1; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : cut[start - 1] + 1;
                cut[end] = Math.min(cut[end], newCutAtEnd);
            }
        }

        return cut[s.length()-1];
    }

    public int on(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return cut(s, 0, memo);
    }

    // aab
    private int cut(String s,
                    int index,
                    int[] memo) {
        if (index == s.length()) return -1;

        if (memo[index] == -1) {
            int min = Integer.MAX_VALUE;
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s.substring(index, i + 1)))
                    min = Math.min(min, 1 + cut(s, i + 1, memo));
            }
            memo[index] = min;
        }

        return memo[index];
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
