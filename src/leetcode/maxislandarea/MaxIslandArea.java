package leetcode.maxislandarea;

public class MaxIslandArea {

    int find(int[][] grid) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    result = Math.max(result, explore(grid, i, j));
            }
        }
        return result;
    }

    int explore(int[][] grid,
                int row,
                int col) {

        if (inBounds(row, col, grid) && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + explore(grid, row, col + 1)
                    + explore(grid, row - 1, col)
                    + explore(grid, row, col - 1)
                    + explore(grid, row + 1, col);
        }

        return 0;

    }

    private boolean inBounds(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }


}
