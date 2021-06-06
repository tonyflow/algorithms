package tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A Trie is a search tree. A data structure built from the characters of the search key.
 */
public class Trie {

    Node root;

    public Trie() {
        this.root = new Node(256);
    }

    public boolean get(String key) {
        Node result = get(key, root, 0);
        if (result == null) return false;
        else return result.isEndOfWord;
    }

    private Node get(String key,
                     Node root,
                     int distance) {
        if (root == null) return null;
        if (distance == key.length()) return root;
        return get(key, root.children[key.charAt(distance)], distance + 1);
    }

    public void put(String key) {
        this.root = put(key, root, 0);
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
                         Queue q) {
        if (startingNode == null) return;
        if (startingNode.isEndOfWord) q.offer(prefix);
        for (int i = 0; i < 256; i++) {
            collect(prefix + (char) i, startingNode.children[i], q);
        }
    }

    /**
     * Longest prefix of the given word that is included in the trie
     */
    public String longestPrefixOf(String word) {
        int end = search(word, root, 0, 0);
        return word.substring(0, end);
    }

    // TODO: 15.03.21 Should repeat this!!!
    private int search(String word,
                       Node startingPoint,
                       int distance,
                       int end) {

        if (startingPoint == null) return end;
        if (startingPoint.isEndOfWord) end = distance;
        if (distance == word.length()) return end;
        return search(word, startingPoint.children[word.charAt(distance)], distance + 1, end);

    }

}
