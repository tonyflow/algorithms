package leetcode.hard.RussianDollEnvelopes;

import java.util.*;

public class RussianDollEnvelopes {

    /**
     * The algorithm: In principle what this problem asks as is for the longest increasing subsequence in two dimensions -
     * based on the width and the height.
     *
     * If we sort the list based on the first dimension then the problem is reduced to finding the longest increasing
     * subsequence based on the second dimension which in this case is the height. The only problem is with envelopes
     * having the same width so for (3,4),(3,5), (3,4) does not fit into (3,5) since the width of the enclosed envelope
     * should be strictly smaller.
     *
     * To avoid producing such a solution, we reverse the ordering in case of equals width. So in the case of (3,4),(3,5),
     * the sorting will produce (3,5),(3,4) and this pair will not be included in the longest increasing subsequence
     * solution for heights.
     */
    public int patienceSorting(int[][] envelopes) {
        List<Integer> patience = new ArrayList();
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return -Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int[] envelope : envelopes) {
            int insertionIndex = Collections.binarySearch(patience, envelope[1]);
            if (insertionIndex < 0) {
                insertionIndex = -insertionIndex - 1;
            }
            if (insertionIndex == patience.size()) patience.add(envelope[1]);
            else patience.set(insertionIndex, envelope[1]);
        }

        return patience.size();
    }

    public int nSquared(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return -Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public int brute(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        return russian(envelopes, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private int russian(int[][] envelopes,
                        int index,
                        int previousWidth,
                        int previousHeight) {
        if (index == envelopes.length) return 0;

        if (envelopes[index][0] > previousWidth && envelopes[index][1] > previousHeight) {
            return Math.max(
                    1 + russian(envelopes, index + 1, envelopes[index][0], envelopes[index][1]),
                    russian(envelopes, index + 1, previousWidth, previousHeight)
            );
        }

        return russian(envelopes, index + 1, previousWidth, previousHeight);
    }


}
