package leetcode;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        int[] sAlpha = getCounts(s);
        int[] tAlpha = getCounts(t);
        return Arrays.equals(sAlpha, tAlpha);
    }

    private int[] getCounts(String s) {
        int[] counts = new int[26];
        Arrays.fill(counts,0);
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
        return counts;
    }
}
