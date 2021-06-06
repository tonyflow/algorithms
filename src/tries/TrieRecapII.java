package tries;

import java.util.LinkedList;
import java.util.Queue;

public class TrieRecapII {

    Node root;

    boolean get(String key) {
        Node result = get(key, root, 0);
        if (result == null) return false;
        else return result.isEndOfWord;
    }

    private Node get(String key,
                     Node root,
                     int distance) {
        if (root == null) return null;
        if (distance == key.length()) return root;
        else return get(key, root.children[key.charAt(distance)], distance + 1);
    }

    void put(String key) {
        this.root = put(key, root, 0);
    }

    private Node put(String key, Node root, int distance) {
        if (root == null) root = new Node();
        if (distance == key.length()) {
            root.isEndOfWord = true;
//            return root;
        } else root.children[key.charAt(distance)] = put(key, root.children[key.charAt(distance)], distance + 1);
        return root;
    }

    public Queue<String> keys() {
        return keysWithPrefix("");
    }

    public Queue<String> keysWithPrefix(String prefix) {
        Queue<String> result = new LinkedList<>();
        collect(prefix, get(prefix, root, 0), result);
        return result;
    }

    private void collect(String prefix,
                         Node root,
                         Queue<String> result) {
        if(root==null) return;
        if(root.isEndOfWord) result.offer(prefix);
        for (int i = 0; i < root.children.length; i++) {
            collect(prefix+(char)i,root.children[i],result );
        }

//        for (char i = 0; i < 256; i++) {
//
//        }
    }



}
