package leetcode.minimumpathsum;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPathSumDP(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i != 0 && j != 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else {
                    // j==0
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid,
                    int row,
                    int col,
                    int[][] memo) {

        if (inBounds(row, col, grid) && memo[row][col] == -1) {
            // Reached the end
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return grid[row][col];
            } else {
                memo[row][col] = grid[row][col] + Math.min(
                        dfs(grid, row, col + 1, memo),
                        dfs(grid, row + 1, col, memo)
                );
                return memo[row][col];
            }

        } else if (inBounds(row, col, grid) && memo[row][col] != -1) {
            return memo[row][col];
        } else return Integer.MAX_VALUE;
    }

    private boolean inBounds(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
