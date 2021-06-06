package backtracking;

import java.util.Arrays;

public class KnightsTour {

    int N;
    int board[][];

    public KnightsTour(int N) {
        this.N = N;
        this.board = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], -1);
        }
    }

    void solve() {
        if (!doSolve(0, 0, 0)) {
            System.out.println("Could not find a solution");
        }
    }

    boolean doSolve(int row, int col, int index) {
        board[row][col] = index;

        if (index == N * N - 1) {
            print();
            return true;
        }

        if (canVisit(row - 2, col + 1) && doSolve(row - 2, col + 1, index + 1)) return true;
        if (canVisit(row - 1, col + 2) && doSolve(row - 1, col + 2, index + 1)) return true;

        if (canVisit(row + 1, col + 2) && doSolve(row + 1, col + 2, index + 1)) return true;
        if (canVisit(row + 2, col + 1) && doSolve(row + 2, col + 1, index + 1)) return true;

        if (canVisit(row + 2, col - 1) && doSolve(row + 2, col - 1, index + 1)) return true;
        if (canVisit(row + 1, col - 2) && doSolve(row + 1, col - 2, index + 1)) return true;

        if (canVisit(row - 1, col - 2) && doSolve(row - 1, col - 2, index + 1)) return true;
        if (canVisit(row - 2, col - 1) && doSolve(row - 2, col - 1, index + 1)) return true;

        board[row][col] = -1;
        return false;
    }

    private void print() {
        System.out.println("Solution: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("===================");
    }

    private boolean canVisit(int row, int col) {

        if (row >= 0 && row < N && col >= 0 && col < N && board[row][col] == -1) {
            return true;
        }

        return false;
    }

}
