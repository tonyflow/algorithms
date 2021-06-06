package leetcode.isomorphicstrings;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int[] sCharMap = constructMap(s);
        int[] tCharMap = constructMap(t);
        return Arrays.equals(sCharMap, tCharMap);
    }

    private int[] constructMap(String s) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int[] map = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (charToIndex.containsKey(s.charAt(i))) {
                map[i] = charToIndex.get(s.charAt(i));
            } else {
                charToIndex.put(s.charAt(i), i);
                map[i] = i;
            }
        }
        return map;
    }
}
