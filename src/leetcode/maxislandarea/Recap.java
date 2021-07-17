package leetcode.maxislandarea;

public class Recap {
    public int maxAreaOfIsland(int[][] grid) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    result = Math.max(result, explore(grid, i, j));
            }
        }
        return result;
    }

    private int explore(int[][] grid, int i, int j) {
        if (inBounds(grid, i, j) && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + explore(grid, i, j + 1) + explore(grid, i + 1, j) + explore(grid, i, j - 1) + explore(grid, i - 1, j);
        } else return 0;
    }

    private boolean inBounds(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
