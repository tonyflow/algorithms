package backtracking;

import java.util.Arrays;

public class NQueens {

    int N;
    int[][] board;

    public NQueens(int N) {
        this.N = N;
        this.board = new int[N][N];
        for (int i = 0; i < this.board.length; i++) {
            Arrays.fill(board[i], 0);
        }
    }

    public void solve() {
        if (!place(board, 0)) {
            System.out.println("Solution was not found");
        }
    }

    private boolean place(int[][] board, int col) {

        if (col == N) {
            print();
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                res = place(board, col + 1);

                // backtrack
                System.out.println("Could not place queen at " + i + ", " + col);
                print();
                board[i][col] = 0;
            }
        }

        return res;
    }

    private void print() {
        System.out.println("Solution: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("===================");
    }

    /**
     * In the board there are already col-1 queens so we only have to check
     */
    private boolean isSafe(int row, int col) {
        // Check row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 1) return false;
        }

        // Check lower diagonal on right side
        for (int i = row, j = col; i < N && j >= 0; j--, i++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }
}
