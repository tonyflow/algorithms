package leetcode;

public class GameOfLife {

    // -1 dead that became living
    // -2 living that became dead
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int living = count(board, i, j);
                if (board[i][j] == 1) {
                    if (living < 2 || living > 3) {
                        board[i][j] = -2;
                    }
                } else {
                    if (living == 3) board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] == -2) board[i][j] = 0;
            }
        }
    }

    public void gameOfLifeExtraSpace(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int living = count(board, i, j);
                if (board[i][j] == 1) {
                    if (living < 2 || living > 3) {
                        result[i][j] = 0;
                    } else {
                        // 2 or 3
                        result[i][j] = board[i][j];
                    }
                } else {
                    if (living == 3) result[i][j] = 1;
                    else result[i][j] = board[i][j];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }

    }

    private int count(int[][] board,
                      int i,
                      int j) {
        int stateCount = 0;
        int[] cols = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] rows = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int k = 0; k < cols.length; k++) {
            int x = rows[k] + i;
            int y = cols[k] + j;
            if (inBounds(board, x, y) && (board[x][y] == 1 || board[x][y] == -2))
                stateCount++;
        }
        return stateCount;
    }

    private boolean inBounds(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
