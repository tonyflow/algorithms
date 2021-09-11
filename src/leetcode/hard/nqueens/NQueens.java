package leetcode.hard.nqueens;

import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        Set<List<String>> result = new HashSet();
        // Initialize board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        place(board, 0, result);

        return new ArrayList(result);
    }

    private void place(char[][] board,
                       int row,
                       Set<List<String>> result) {

        // This means that we've reached to the end of the board without having to
        // backtrack
        if (row == board.length) {
            boardToResult(board, result);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (canPlace(board, row, c)) {
                board[row][c] = 'Q';
                place(board, row + 1, result);
                board[row][c] = '.';
            }
        }
    }
    private void boardToResult(char[][] board, Set<List<String>> result) {
        List<String> partial = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                builder.append(board[i][j]);
            }
            partial.add(builder.toString());
        }
        result.add(partial);
    }

    private boolean canPlace(char[][] board, int row, int col) {

        // check above
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == 'Q') return false;

        // check below
        for (int i = row + 1; i < board.length; i++)
            if (board[i][col] == 'Q') return false;

        // check left
        for (int i = col - 1; i >= 0; i--)
            if (board[row][i] == 'Q') return false;

        // check right
        for (int i = col + 1; i < board.length; i++)
            if (board[row][i] == 'Q') return false;

        // check right diagonal up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        // check left diagonal up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // check right diagonal down
        for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++)
            if (board[i][j] == 'Q') return false;

        // check left diagonal down
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--)
            if (board[i][j] == 'Q') return false;

        return true;
    }
}
