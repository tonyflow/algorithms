package leetcode.longestpalindromicsubsequence;

public class Playground {

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
//        System.out.println(longestPalindromicSubsequence.longestPalindromicSubseq("bbbab"));
//        System.out.println(longestPalindromicSubsequence.longestPalindromicSubseq("cbbd"));
//        System.out.println(longestPalindromicSubsequence.longestPalindromicSubseq("a"));
//        System.out.println(longestPalindromicSubsequence.longestPalindromicSubseq("aabaa"));

        System.out.println(longestPalindromicSubsequence.tabulation("bbbab"));
        System.out.println(longestPalindromicSubsequence.tabulation("cbbd"));
        System.out.println(longestPalindromicSubsequence.tabulation("a"));
        System.out.println(longestPalindromicSubsequence.tabulation("aabaa"));

    }
}
