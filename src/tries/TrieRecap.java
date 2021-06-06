package tries;

import java.util.LinkedList;
import java.util.Queue;

public class TrieRecap {

    Node root;

    public TrieRecap() {
        this.root = new Node();
    }

    public boolean get(String key) {
        Node result = get(key, root, 0);
        if (result == null) return false;
        return result.isEndOfWord;
    }

    private Node get(String key,
                     Node root,
                     int distance) {
        if (root == null) return null;
        if (distance == key.length()) return root;
        return get(key, root.children[key.charAt(distance)], distance + 1);
    }

    public void put(String key) {
        put(key, root, 0);
    }

    private Node put(String key,
                     Node root,
                     int distance) {
        if (root == null) root = new Node();
        if (distance == key.length()) {
            root.isEndOfWord = true;
            return root;
        } else {
            root.children[key.charAt(distance)] = put(key, root.children[key.charAt(distance)], distance + 1);
        }

        return root;
    }

    public Queue<String> keys() {
        return keysWithPrefix("");
    }

    public Queue<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<>();
        Node startingNode = get(prefix, root, 0);
        collect(prefix, startingNode, q);
        return q;
    }

    private void collect(String prefix,
                         Node startingNode,
                         Queue<String> keys) {
        if (startingNode == null) return;
        if (startingNode.isEndOfWord) keys.offer(prefix);
        for (int i = 0; i < 256; i++) {
            collect(prefix + (char) i, startingNode.children[i], keys);
        }
    }

    public String longestPrefixOf(String word) {
        return word.substring(0, 1);
    }
}
