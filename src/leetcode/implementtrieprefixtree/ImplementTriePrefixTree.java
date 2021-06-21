package leetcode.implementtrieprefixtree;

public class ImplementTriePrefixTree {

    class TrieNode {

        TrieNode[] children = new TrieNode[26]; // carry lower case english letters
        boolean isWord;

        public TrieNode() {
            isWord = false;
        }
    }

    private TrieNode root = new TrieNode();

    public TrieNode create() {
        return root;
    }

    boolean get(String s) {
        TrieNode found = get(root, s, 0);
        if (found == null) return false;
        else return found.isWord;
    }

    private TrieNode get(TrieNode root, String s, int index) {
        if (root == null) return null;
        if (root.isWord && index == s.length()) return root;
        else return get(root.children[s.charAt(index) - 'a'], s, index + 1);
    }

    void put(String s) {
        this.root = put(root, s, 0);
    }

    private TrieNode put(TrieNode root, String s, int index) {
        if (root == null) root = new TrieNode();
        if (index == s.length()) {
            root.isWord = true;
        } else {
            root.children[s.charAt(index) - 'a'] = put(root.children[s.charAt(index) - 'a'], s, index + 1);
        }
        return root;
    }

    boolean startsWith(String prefix) {
        return startsWith(this.root, prefix, 0);
    }

    private boolean startsWith(TrieNode root, String s, int index) {
        if (index >= s.length()) return true;
        else return startsWith(root.children[s.charAt(index) - 'a'], s, index + 1);
    }
}
