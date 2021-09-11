package leetcode.hard.nqueens;

import java.util.*;

/**
 * This is unsuccessful attempt where I tried to explore all directions around the current cell. This
 * approach is not really reasonable since due to the restrictions that we have:
 * 1. No two queens on the same row
 * 2. No two queens on the same column
 * 3. No two queens on the same diagonal
 * it does not make sense to explore board[i][j+1] coming from board[i][j]
 *
 * This approach works but it is very slow due to the size of the universe of solutions it should explore.
 */
public class ExploringAllDirectionsRecursively {

    int[][] directions = {
            {-1, 0}, // up
            {-1, 1}, // diagonally right up
            {0, 1}, // right
            {1, 1}, // diagonally right down
            {-1, 0}, // down
            {-1, -1}, // diagonally left down
            {0, -1}, // left
            {-1, -1}  // diagonally left up
    };

    public List<List<String>> solveNQueens(int n) {

        Set<List<String>> result = new HashSet();
        // Initialize board
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                place(board, visited, i, j, n, result);
            }
        }

        return new ArrayList(result);
    }

    private void place(char[][] board,
                       boolean[][] visited,
                       int row,
                       int col,
                       int n,
                       Set<List<String>> result) {

        if (inBounds(board, row, col) && !visited[row][col]) {
            int remainingQueens = n;
            visited[row][col] = true;

            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                remainingQueens--;
            }

            if (remainingQueens == 0) {
                boardToResult(board, result);
            } else {
                for (int d = 0; d < directions.length; d++) {
                    place(board, visited, row + directions[d][0], col + directions[d][1], remainingQueens, result);
                }
            }

            // backtrack
            visited[row][col] = false;
            board[row][col] = '.';
        }
    }

    private boolean inBounds(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private void printBoard(char[][] board) {
        for (char[] row : board) System.out.println(Arrays.toString(row));
        System.out.println("=========================================");
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
