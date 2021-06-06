package leetcode;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    doFindIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void doFindIsland(char[][] grid, int i, int j) {
        if (inBounds(i, j, grid) && grid[i][j] == '1') {
            grid[i][j] = 0;
            doFindIsland(grid, i + 1, j);
            doFindIsland(grid, i - 1, j);
            doFindIsland(grid, i, j + 1);
            doFindIsland(grid, i, j - 1);
        } else {
            return;
        }
    }

    private boolean inBounds(int currentRow, int currentColumn, char[][] board) {
        return (
                currentRow >= 0 &&
                        currentRow < board.length
        ) && (
                currentColumn >= 0 &&
                        currentColumn < board[0].length
        );
    }

}
