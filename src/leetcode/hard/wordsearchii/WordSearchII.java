package leetcode.hard.wordsearchii;

import java.util.*;

public class WordSearchII {

    class TrieNode {
        TrieNode[] alphabet;
        boolean isWord;
        String word;

        public TrieNode(int size) {
            this.isWord = false;
            alphabet = new TrieNode[size];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = createTrie(words);
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                searchTrie(board, visited, trie, i, j, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void searchTrie(char[][] board,
                            boolean[][] visited,
                            TrieNode root,
                            int i,
                            int j,
                            Set<String> result) {

        if (root == null) return;
        if (root.isWord) result.add(root.word);
        if (inBounds(board, i, j) && !visited[i][j]) {

            int[][] directions = {
                    {-1, 0},
                    {0, 1},
                    {1, 0},
                    {0, -1}
            };
            visited[i][j] = true;
            char current = board[i][j];
            for (int d = 0; d < directions.length; d++) {
                searchTrie(
                        board,
                        visited,
                        root.alphabet[current - 'a'],
                        i + directions[d][0],
                        j + directions[d][1],
                        result
                );
            }
            visited[i][j] = false;
        }
    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode(26);
        for (String word : words) {
            addToTrie(root, word);
        }

        return root;
    }

    private void addToTrie(TrieNode root, String word) {
        doAdd(root, word, 0);
    }

    private TrieNode doAdd(TrieNode root, String word, int index) {
        if (root == null) root = new TrieNode(26);
        if (index == word.length()) {
            root.isWord = true;
            root.word = word;
            return root;
        }

        root.alphabet[word.charAt(index) - 'a'] = doAdd(root.alphabet[word.charAt(index) - 'a'], word, index + 1);
        return root;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////


    public List<String> tle(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, visited, new StringBuilder(), dictionary, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void search(char[][] board,
                        int i,
                        int j,
                        boolean[][] visited,
                        StringBuilder builder,
                        Set<String> dictionary,
                        Set<String> result) {

        if (inBounds(board, i, j) && !visited[i][j]) {

            int[][] directions = {
                    {-1, 0},
                    {0, 1},
                    {1, 0},
                    {0, -1}
            };
            visited[i][j] = true;
            builder.append(board[i][j]);
            if (dictionary.contains(builder.toString())) result.add(builder.toString());
            for (int d = 0; d < directions.length; d++) {
                search(board, i + directions[d][0], j + directions[d][1], visited, builder, dictionary, result);
            }
            builder.deleteCharAt(builder.length() - 1);
            visited[i][j] = false;
        }
    }

    private boolean inBounds(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
