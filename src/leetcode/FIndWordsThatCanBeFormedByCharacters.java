package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndWordsThatCanBeFormedByCharacters {

    static int find(String[] words, String chars) {

        // Determine frequencies
        int[] frequencies = new int[26];
        List<String> result = new ArrayList<>();
        Arrays.fill(frequencies, 0);
        for (char c : chars.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for (String word : words) {
            boolean isGood = true;
            for (char c : word.toCharArray()) {
                if (frequencies[c - 'a'] == 0) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) result.add(word);
        }

        return result.stream().map(word -> word.length()).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(find(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(find(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
    }
}
