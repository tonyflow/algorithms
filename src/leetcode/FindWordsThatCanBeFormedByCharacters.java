package leetcode;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {

    static int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        int result = 0;
        Arrays.fill(counts, 0);

        for (char c : chars.toCharArray()) {
            counts[c - 'a']++;
        }

        for (String word : words) {
            boolean canFormWord = true;
            int[] tmp = new int[26];
            Arrays.fill(tmp, 0);
            for (char c : word.toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26 && canFormWord; i++) {
                if (counts[i] < tmp[i]) canFormWord = false;
            }
            if (canFormWord) {
                result += word.length();
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat","tree"},"atach"));
    }

}
