package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    static int usingHashMap(String s) {

        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (counts.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }

    static int usingHashTable(String s) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (counts[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(usingHashTable("lleettccooddeez"));
        System.out.println(usingHashMap("lleettccooddeez"));
    }
}
