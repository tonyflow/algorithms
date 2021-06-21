package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> results = new ArrayList<>();
        int[] referenceCounts = getCounts(p);
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (true) {
            }
        }
        return results;
    }

    public List<Integer> mine(String s, String p) {
        ArrayList<Integer> results = new ArrayList<>();
        if (p.length() > s.length()) return results;
        int[] referenceCounts = getCounts(p);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String fragment = s.substring(i, i + p.length());
            int[] fragmentCounts = getCounts(fragment);
            if (Arrays.equals(fragmentCounts, referenceCounts)) results.add(i);
        }
        return results;
    }

    private int[] getCounts(String p) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : p.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }
}
