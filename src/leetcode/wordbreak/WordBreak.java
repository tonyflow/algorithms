package leetcode.wordbreak;

import java.util.*;

public class WordBreak {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord;

        public TrieNode() {
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        TrieNode root = null;
        for (String word : wordDict) {
            root = put(root, word, 0);
        }

        while (!s.isEmpty()) {
            int matched = 1;
            ArrayList<String> results = new ArrayList<>();
            match(root, s, "", results, 0);
            if (matched > 0) {
                s = s.substring(matched);
            } else break;
        }

        return s.isEmpty();
    }

    private TrieNode put(TrieNode root,
                         String s,
                         int position) {
        if (root == null) root = new TrieNode();
        if (position == s.length()) root.isWord = true;
        else root.next[s.charAt(position) - 'a'] = put(root.next[s.charAt(position) - 'a'], s, position + 1);
        return root;
    }

    private void match(TrieNode root,
                       String s,
                       String path,
                       List<String> results,
                       int position) {
        if (root != null) {
            if (root.isWord) results.add(path);
            else if (position + 1 < s.length())
                match(root.next[s.charAt(position) - 'a'], s, path + s.charAt(position), results, position + 1);
        }
    }

    private TrieNode find(TrieNode root,
                          String s,
                          int position) {
        if (root == null) return null;
        if (position == s.length()) return root;
        else return find(root.next[s.charAt(position) - 'a'], s, position + 1);
    }


    public boolean breakW(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        helper(s, memo, wordDict);
        return helper(s, memo, wordDict);
    }

    private boolean helper(String s,
                           Map<String, Boolean> memo,
                           List<String> wordDict) {
        if (s.isEmpty()) return true;

        boolean composite = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (!memo.containsKey(s.substring(word.length()))) {
                    memo.put(s.substring(word.length()), helper(s.substring(word.length()), memo, wordDict));
                }
                composite = composite || memo.get(s.substring(word.length()));
            }
        }
        return composite;
    }
}
