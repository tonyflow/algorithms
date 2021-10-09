package algorithms.knuthmorrispratt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Useful resources
 * - https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
 * - https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=2s
 * - https://www.youtube.com/watch?v=KG44VoDtsAA
 *
 */
public class KnuthMorrisPratt {

    List<Integer> KMPAllIndexes(String a, String b) {
        int i = 0;
        int j = 0;
        int[] ps = computePSArray(b);
        List<Integer> indexes = new ArrayList();
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }

            if (j == b.length()) {
                indexes.add(i - j);
                j = ps[j - 1];
            } else if (a.charAt(i) != b.charAt(j)) {
                if (j != 0) j = ps[j - 1];
                else i++;
            }
        }
        return indexes;
    }

    int KMPIndex(String a, String b) {
        int i = 0;
        int j = 0;
        int[] ps = computePSArray(b);
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) j = ps[j - 1];
                else i++;
            }
        }

        if (j == b.length()) return i - j;
        return -1;
    }

    boolean KMPExists(String a, String b) {
        int i = 0;
        int j = 0;
        int[] ps = computePSArray(b);
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) j = ps[j - 1];
                else i++;
            }
        }

        if (j == b.length()) return true;
        return false;
    }

    /**
     * Compute the array that identifies at point i if there is a suffix which is also a prefix
     * for the pattern string
     */
    private int[] computePSArray(String pattern) {
        int[] ps = new int[pattern.length()];
        Arrays.fill(ps, 0);

        int left = 0;
        int right = 1;
        while (right < pattern.length()) {
            if (pattern.charAt(left) == pattern.charAt(right)) {
                ps[right] = left + 1;
                right++;
                left++;
            } else {
                if (left != 0) left = ps[left - 1];
                else {
                    ps[right] = ps[left]; // or ps[right] = ps[0] since left == 0 in this case
                    right++;
                }
            }
        }

        return ps;
    }

    /**
     * Naive approach
     * Find b in a  - O(m*n)
     */
    int naive(String a, String b) {
        if (b.length() > a.length()) return -1;

        for (int i = 0; i < a.length(); i++) {
            int cursor = 0;
            boolean match = true;
            while (cursor < b.length() && i + cursor < a.length() && match) {
                if (a.charAt(i + cursor) == b.charAt(cursor)) {
                    cursor++;
                } else {
                    match = false;
                }
            }
            if (cursor == b.length()) return i;
        }

        return -1;
    }
}
