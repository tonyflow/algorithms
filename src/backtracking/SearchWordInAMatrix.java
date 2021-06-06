package backtracking;

import java.util.Arrays;

public class SearchWordInAMatrix {

    int[][] path;

    void search(char[][] board, String word) {

        path = new int[board.length][board[0].length];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], -1);
        }

        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (doSearch(board, word, path, "", i, j, 0)) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("Solution not found");
        }
    }

    private boolean doSearch(char[][] board,
                             String word,
                             int[][] path,
                             String soFar,
                             int row,
                             int col,
                             int index) {

        soFar += Character.toString(board[row][col]);
        path[row][col] = index;

        if (soFar.length() > word.length()) {
            path[row][col] = -1;
            return false;
        }

        if (soFar.equals(word)) {
            print();
            return true;
        }

        if (isSafe(row - 1, col) && doSearch(board, word, path, soFar, row - 1, col, index + 1)) return true;
        if (isSafe(row - 1, col + 1) && doSearch(board, word, path, soFar, row - 1, col + 1, index + 1)) return true;
        if (isSafe(row, col + 1) && doSearch(board, word, path, soFar, row, col + 1, index + 1)) return true;
        if (isSafe(row + 1, col + 1) && doSearch(board, word, path, soFar, row + 1, col + 1, index + 1)) return true;
        if (isSafe(row + 1, col) && doSearch(board, word, path, soFar, row + 1, col, index + 1)) return true;
        if (isSafe(row + 1, col - 1) && doSearch(board, word, path, soFar, row + 1, col - 1, index + 1)) return true;
        if (isSafe(row, col - 1) && doSearch(board, word, path, soFar, row, col - 1, index + 1)) return true;
        if (isSafe(row - 1, col - 1) && doSearch(board, word, path, soFar, row - 1, col - 1, index + 1)) return true;

        path[row][col] = -1;

        return false;
    }

    private boolean isSafe(int row, int col) {
        if (row >= 0 && row < path.length && col >= 0 && col < path[0].length && path[row][col] == -1) return true;
        return false;
    }

    private void print() {
        System.out.println("Solution: ");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.printf("%2d ", path[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("===================");
    }
}
