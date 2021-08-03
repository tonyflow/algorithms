package leetcode;

import java.util.*;

public class TopKFrequentWords {

    class WordKey {
        int freq;
        String word;

        public WordKey(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }

        int getFreq() {
            return this.freq;
        }

        String getWord() {
            return this.word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        TreeMap<Integer, List<String>> ordered = new TreeMap<>(Comparator.reverseOrder());
        PriorityQueue<WordKey> helper = new PriorityQueue<>(Comparator.comparing(WordKey::getFreq).reversed().thenComparing(WordKey::getWord));

        // word to frequencies
        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);


        // frequencies to list of words
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String word = e.getKey();
            int frequency = e.getValue();
            if (ordered.containsKey(frequency)) {
                List<String> updated = ordered.get(frequency);
                updated.add(word);
                ordered.put(frequency, updated);
            } else {
                List<String> keeper = new ArrayList<>();
                keeper.add(word);
                ordered.put(frequency, keeper);
            }
        }

        for (Map.Entry<Integer, List<String>> e : ordered.entrySet()) {
            int frequency = e.getKey();
            List<String> w = e.getValue();

            for (String word : w)
                helper.add(new WordKey(frequency, word));

        }

        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(helper.poll().getWord());
            k--;
        }

        return result;
    }
}
