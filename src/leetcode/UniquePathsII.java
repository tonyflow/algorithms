package leetcode;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] m : memo) Arrays.fill(m, -1);
        return doFind(obstacleGrid, 0, 0, memo);
    }

    private int doFind(int[][] grid,
                       int row,
                       int col,
                       int[][] memo) {

        if (row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] == 1) return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1) return 1;
        if (memo[row][col] == -1)
            memo[row][col] = doFind(grid, row + 1, col, memo) + doFind(grid, row, col + 1, memo);

        return memo[row][col];
    }
}
