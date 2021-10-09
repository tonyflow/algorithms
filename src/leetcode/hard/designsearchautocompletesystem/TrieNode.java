package leetcode.hard.designsearchautocompletesystem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrieNode {
    TrieNode[] children;
    PriorityQueue<Integer> sentencesHierarchy;

    public TrieNode(Comparator comparator) {
        // Allow all ASCI characters since we have to handle spaces and #
        this.children = new TrieNode[256];
        sentencesHierarchy = new PriorityQueue(comparator);
    }
}
