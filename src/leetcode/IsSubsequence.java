package leetcode;

/**
 * Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to
 * check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 *
 * https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments/92266
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int currentS = 0;
        int currentT = 0;
        int numOfSCharactersFoundInT = 0;

        while (currentS < s.length() && currentT < t.length()) {
            if (s.charAt(currentS) == t.charAt(currentT)) {
                currentS++;
                currentT++;
                numOfSCharactersFoundInT++;
            } else {
                currentT++;
            }
        }

        return numOfSCharactersFoundInT == s.length();
    }
}
