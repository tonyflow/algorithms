package backtracking;

public class SudokuSolver {

    void solveSudoku(char[][] board) {
        doSolve(board);
    }

    boolean doSolve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;

                for (char k = '1'; k <= '9'; k++) {
                    board[i][j] = k;
                    if (isValid(board, i, j) && doSolve(board)) {
                        return true;
                    }
                    board[i][j] = '.';

                }
                return false;
            }
        }
        return true;
    }

    static private boolean isValid(char[][] board,
                                   int row,
                                   int column) {
        // Check if there is the same number in this row
        for (int i = 0; i < 9; i++) {
            if (i == column) continue;
            if (board[row][column] == board[row][i]) return false;
        }

        // Check if there is the same number in this column
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[row][column] == board[i][column]) return false;
        }

        // Check containing 3x3 block of numbers
        //[1,1]
        //[4,4]
        //[7,7]
        int x = row / 3 * 3;
        int y = column / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i == row && j == column) continue;
                if (board[i][j] == board[row][column]) return false;
            }
        }

        return true;
    }

}
