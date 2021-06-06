package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    static String find(String paragraph, String[] banned) {

        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> frequencies = new HashMap<>();

        for (String word : banned) {
            bannedSet.add(word);
        }

        Integer maxFrequency = Integer.MIN_VALUE;
        String maxWord = "";
        for (String word : paragraph.replaceAll("\\p{Punct}", " ").toLowerCase().split(" ")) {
            word = word.trim();
            if(word.isEmpty()) continue;
            if (!bannedSet.contains(word)) {
                Integer freq = frequencies.getOrDefault(word, 0);
                freq += 1;
                if (maxFrequency < freq) {
                    maxFrequency = freq;
                    maxWord = word;
                }
                frequencies.put(word, freq);
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = new String[]{"hit"};

        String paragraph = "Bob. hIt, baLl";
        String[] banned = new String[]{"bob", "hit"};
        System.out.println(find(paragraph, banned));
    }
}
