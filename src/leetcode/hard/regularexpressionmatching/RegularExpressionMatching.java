package leetcode.hard.regularexpressionmatching;

import java.util.Arrays;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(s, 0, p, 0, memo);
    }

    private boolean match(String s,
                          int si,
                          String p,
                          int pi,
                          Boolean[][] memo) {

        if (pi == p.length()) return si == s.length();
        if (memo[si][pi] != null) return memo[si][pi];

        boolean firstMatch = si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            memo[si][pi] = match(s, si, p, pi + 2, memo) || (firstMatch && match(s, si + 1, p, pi, memo));
        } else {
            memo[si][pi] = firstMatch && match(s, si + 1, p, pi + 1, memo);
        }

        return memo[si][pi];
    }

    public boolean isMatchWithoutDP(String s, String p) {

        if (p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatchWithoutDP(s, p.substring(2)) || // either ignore this part of the pattern - in that case * is equal to 0 occurrences of the character OR
                    (firstMatch && isMatchWithoutDP(s.substring(1), p)); // accept the first match (whether this is true or false) and advance the pointer for s
        } else {
            return firstMatch && isMatchWithoutDP(s.substring(1), p.substring(1));
        }
    }

    // works on 286 / 352 test cases
    // an interesting case that fails "aaa" / "a*a"
    public boolean isMatchNotComplete(String s, String p) {
        return doMatch(s, 0, p, 0);
    }

    private boolean doMatch(String s,
                            int si,
                            String p,
                            int pi) {

        if (si == s.length() && pi == p.length()) return true;

        if ((si == s.length() && pi != p.length()) || (si != s.length() && pi == p.length())) return false;

        // cb / ca or c / c or c / .
        boolean currentCharsMatch = s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.';
        if ((pi + 1 < p.length() && p.charAt(pi + 1) != '*') && currentCharsMatch)
            // match and advance
            return doMatch(s, si + 1, p, pi + 1);

        // if character at position pi+1 is a Kleene star then we have to decide whether to skip or match
        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            if (s.charAt(si) == p.charAt(pi)) {
                // c* / cccc match part of the string
                while (si < s.length() && s.charAt(si) == p.charAt(pi)) si++;
                return doMatch(s, si, p, pi + 2);
            }

            // .* zero or more of any character
            if (p.charAt(pi) == '.') return doMatch(s, s.length(), p, pi + 2);

            // c* / a skip part of pattern
            if (s.charAt(si) != p.charAt(pi)) {
                return doMatch(s, si, p, pi + 2);
            }
        }

        // at this point we have something like bb / aa or bb / .a
        return currentCharsMatch && doMatch(s, si + 1, p, pi + 1);
    }
}
