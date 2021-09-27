package leetcode.hard;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        // dp[i+1][j+1] represents the number of times that the s(0,j) contains t(0,i)
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // t(0,0) is the empty string and this can be found at least once in every string so
        // t(0,0) can be found once in s(0,0)
        // t(0,0) can be found once in s(0,1)
        // t(0,0) can be found once in s(0,2)
        // t(0,0) can be found once in s(0,3) ...
        for (int j = 0; j < s.length() + 1; j++)
            dp[0][j] = 1;

        // The empty string cannot contain any other non-empty strings as subsequences
        for (int i = 1; i < t.length() + 1; i++)
            dp[i][0] = 0;

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public int bruteForce(String s, String t) {
//        return traverse1(s, 0, new StringBuilder(), t);
        return traverse2(s, 0, t, 0);
    }

    private int traverse2(String s,
                          int is,
                          String t,
                          int it) {
        if (is == s.length() && it == t.length()) {
            return 1;
        }

        if (it == t.length()) return 1;

        if (is == s.length()) return 0;

        if (s.charAt(is) == t.charAt(it)) {
            return traverse2(s, is + 1, t, it + 1) + traverse2(s, is + 1, t, it);
        } else {
            return traverse2(s, is + 1, t, it);
        }
    }

    private int traverse1(String s,
                          int index,
                          StringBuilder builder,
                          String t) {

        if (index == s.length() && builder.toString().equals(t)) {
            return 1;
        }

        if (index == s.length()) return 0;

        // take the current character
        builder.append(s.charAt(index));
        int take = traverse1(s, index + 1, builder, t);
        builder.deleteCharAt(builder.length() - 1);

        int doNotTake = traverse1(s, index + 1, builder, t);
        return take + doNotTake;
    }
}
