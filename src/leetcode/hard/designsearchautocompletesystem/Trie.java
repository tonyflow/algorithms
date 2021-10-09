package leetcode.hard.designsearchautocompletesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trie {
    TrieNode root;
    Comparator comparator;

    public Trie(Comparator comparator) {
        this.root = new TrieNode(comparator);
        this.comparator = comparator;
    }

    public void insert(String s, int arrayIndex, int maxQueueSize) {
        insert(s, 0, this.root, arrayIndex, maxQueueSize);
    }

    private TrieNode insert(String s,
                            int index,
                            TrieNode root,
                            int arrayIndex,
                            int maxQueueSize) {

        if (index == s.length()) return null;
        if (root == null) root = new TrieNode(this.comparator);

        // Update trie structure
        root.children[s.charAt(index)] = insert(s, index + 1, root.children[s.charAt(index)], arrayIndex, maxQueueSize);

        // Update priority queue
        if (root.sentencesHierarchy.size() == maxQueueSize) root.sentencesHierarchy.poll();
        root.sentencesHierarchy.offer(arrayIndex);

        return root;
    }

    public List<Integer> get(String s) {
        return get(s, 0, this.root);
    }

    private List<Integer> get(String s,
                              int index,
                              TrieNode root) {
        if (root == null) return new ArrayList();
        if (index == s.length()) {
            return new ArrayList(root.sentencesHierarchy);
        }
        return get(s, index + 1, root.children[s.charAt(index)]);
    }
}
