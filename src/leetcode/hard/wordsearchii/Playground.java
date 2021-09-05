package leetcode.hard.wordsearchii;

public class Playground {

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a'}};
        String[] words = {"a"};
        wordSearchII.findWords(board, words);
    }
}
