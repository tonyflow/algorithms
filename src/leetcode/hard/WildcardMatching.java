package leetcode.hard;

public class WildcardMatching {

    public boolean tabulation(String s, String p) {
        return false;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return match(s, 0, p, 0, memo);
    }

    private boolean match(String s,
                          int si,
                          String p,
                          int pi,
                          Boolean[][] memo) {

        if (pi == p.length() && si == s.length()) return true;
        if (pi == p.length() && si != s.length()) return false;

        // we must exhaust all characters in p - we're out of bounds for memoization here
        if (pi != p.length() && si == s.length()) return p.charAt(pi) == '*' ? match(s, si, p, pi + 1, memo) : false;

        if (memo[si][pi] == null) {
            // pi != p.length() && si != s.length()
            boolean firstMatch = s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?' || p.charAt(pi) == '*';

            if (p.charAt(pi) == '*')
                memo[si][pi] = (firstMatch && match(s, si + 1, p, pi, memo)) // match the first character and keep * valid for further recurrences
                        || match(s, si, p, pi + 1, memo) // match the empty string and invalidate *
                        || (firstMatch && match(s, si + 1, p, pi + 1, memo)); // match the first character and invalidate *
            else
                // s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'
                memo[si][pi] = firstMatch && match(s, si + 1, p, pi + 1, memo);
        }

        return memo[si][pi];
    }
}
