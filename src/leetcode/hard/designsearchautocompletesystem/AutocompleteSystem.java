package leetcode.hard.designsearchautocompletesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class AutocompleteSystem {

    String[] sentences;
    int[] times;
    Trie trie;
    StringBuilder builder;

    /**
     * Historical data constructor
     *
     * @param sentences string array consists of previously typed sentences
     * @param times     times a sentence has been typed
     */
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.times = times;
        this.sentences = sentences;
        this.builder =  new StringBuilder();
        Comparator<Integer> comparator = Comparator.comparingInt(a -> times[a]);
        this.trie = new Trie(comparator);

        for (int i = 0; i < sentences.length; i++) {
            this.trie.insert(sentences[i], i, 3);
        }
    }

    Trie getTrie() {
        return this.trie;
    }


    List<String> input(char c) {
        List<Integer> sIndexes = this.trie.get(builder.append(c).toString());
        List<String> results = new ArrayList();
        for(int index: sIndexes)
            results.add(sentences[index]);
        return results;
    }
}
