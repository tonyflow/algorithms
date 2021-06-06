package leetcode.islandperimeter;

public class IslandPerimeter {

    int find(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return explore(grid, visited, i, j);
                }
            }
        }
        return 0;
    }

    private int explore(int[][] grid,
                        boolean[][] visited,
                        int row,
                        int col) {
        if (inBounds(row, col, grid) &&
                grid[row][col] == 1 &&
                !visited[row][col]) {
            visited[row][col] = true;
            int right = explore(grid, visited, row, col + 1);
            int down = explore(grid, visited, row + 1, col);
            int left = explore(grid, visited, row, col - 1);
            int up = explore(grid, visited, row - 1, col);
            int total = right + down + left + up;
//            System.out.println("row " + row + " col " + col + " right " + right + " left " + left + " up " + up + " down " + down + " total " + total);
            return total;
        } else if (inBounds(row, col, grid) && visited[row][col]) {
            return 0;
        } else {
            return 1;
        }
    }

    private boolean inBounds(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
