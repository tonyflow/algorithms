package leetcode.wordsearch;

import java.util.Arrays;

public class WordSearchIn2DArray {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && doFind(board, i, j, "", visited, word)) return true;
                initializeToFalse(visited);
            }
        }
        return false;
    }

    private void initializeToFalse(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private boolean doFind(char[][] board,
                           int currentRow,
                           int currentColumn,
                           String pathWord,
                           boolean[][] visited,
                           String word) {

        if(pathWord.length() > word.length()) return false;
        if (pathWord.equals(word)) return true;

        if (!inBounds(currentRow, currentColumn, board)) return false;

        visited[currentRow][currentColumn] = true;
        pathWord = pathWord + board[currentRow][currentColumn];

        if (doFind(board, currentRow + 1, currentColumn, pathWord, visited, word) ||
                doFind(board, currentRow, currentColumn + 1, pathWord, visited, word) ||
                doFind(board, currentRow - 1, currentColumn, pathWord, visited, word) ||
                doFind(board, currentRow, currentColumn - 1, pathWord, visited, word)) return true;

        visited[currentRow][currentColumn] = false;
//        pathWord = pathWord.substring(0, pathWord.length() - 1);
        return false;
    }

    private boolean inBounds(int currentRow, int currentColumn, char[][] board) {
        return (currentRow >= 0 && currentRow < board.length) && (currentColumn >= 0 && currentColumn < board[0].length);
    }

}
