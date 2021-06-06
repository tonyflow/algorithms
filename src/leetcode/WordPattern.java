package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");

        if (pattern.length() != split.length) return false;

        int[] patternMap = new int[pattern.length()];
        for (int i = 0; i < pattern.toCharArray().length; i++) {
            patternMap[i] = pattern.indexOf(pattern.charAt(i));
        }

        int[] sMap = new int[split.length];
        HashMap<String, Integer> wordToFirstIndex = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (!wordToFirstIndex.containsKey(split[i])) {
                wordToFirstIndex.put(split[i], i);
            }
            sMap[i] = wordToFirstIndex.get(split[i]);
        }

        return Arrays.equals(sMap, patternMap);
    }
}
