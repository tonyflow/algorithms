package leetcode.hard;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] m : memo)
            Arrays.fill(m, -1);
        memo[word1.length()][word2.length()] = 0;
        return edit(word1, 0, word2, 0, memo);
    }

    private int edit(String a,
                     int ai,
                     String b,
                     int bi,
                     int[][] memo) {

        if (memo[ai][bi] != -1) return memo[ai][bi];

        // In this case a == b
        if (ai == a.length() && bi == b.length()) return 0;
        // If we have not reached the end for one of the two strings we need to delete the remaining characters of the longer one
        if (ai < a.length() && bi == b.length()) {
            memo[ai][bi] = 1 + edit(a, ai + 1, b, bi, memo); // delete character from a or insert one
            return memo[ai][bi];
        }
        if (bi < b.length() && ai == a.length()) {
            memo[ai][bi] = 1 + edit(a, ai, b, bi + 1, memo); // delete character from b pr insert one
            return memo[ai][bi];
        }

        // We do not have to do anything in case the characters are the same so we just proceed
        // we are editing no strings in this case
        if (a.charAt(ai) == b.charAt(bi)) {
            memo[ai][bi] = edit(a, ai + 1, b, bi + 1, memo);
            return memo[ai][bi];
        }

        // characters differ e.g. ca rf, so we have 4 options here
        int replaceCharacterAtAOrB = 1 + edit(a, ai + 1, b, bi + 1, memo);// ra / rf or ca/cf
        int deleteCharacterFromA = 1 + edit(a, ai + 1, b, bi, memo); // a / rf
        int deleteCharacterFromB = 1 + edit(a, ai, b, bi + 1, memo); // ca / f
        int insertCharacterInA = 1 + edit(a, ai + 1, b, bi + 1, memo); // rca / rf
        int insertCharacterInB = 1 + edit(a, ai + 1, b, bi + 1, memo); // ca / crf

        memo[ai][bi] = Math.min(
                replaceCharacterAtAOrB,
                Math.min(
                        deleteCharacterFromA,
                        Math.min(
                                deleteCharacterFromB,
                                Math.min(
                                        insertCharacterInA,
                                        insertCharacterInB
                                )
                        )
                )
        );

        return memo[ai][bi];
    }
}
