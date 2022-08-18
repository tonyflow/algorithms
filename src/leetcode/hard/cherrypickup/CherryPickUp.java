package leetcode.hard.cherrypickup;

import java.util.ArrayList;
import java.util.List;

public class CherryPickUp {


    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][][] dp = new Integer[n][n][n][n];
        return Math.max(0,pickUp(grid, dp, 0, 0, 0, 0));
    }

    private int pickUp(int[][] grid,
                       Integer[][][][] dp,
                       int r1,
                       int c1,
                       int r2,
                       int c2) {

        int n = grid.length;
        if (r1 < 0 || r1 == n || c1 < 0 || c1 == n || r2 < 0 || r2 == n || c2 < 0 || c2 == n)
            return Integer.MIN_VALUE;

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

        if (dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];

        // check if user 1 has reached the destination
        if (r1 == n - 1 && c1 == n - 1) {
            dp[r1][c1][r2][c2] = grid[r1][c1];
        } else if (r2 == n - 1 && c2 == n - 1) {
            dp[r1][c1][r2][c2] = grid[r2][c2];
        } else {
            int cherries;
            // check if user 1 and 2 are on the same cell
            if (r1 == r2 && c1 == c2) cherries = grid[r1][c1];
            else cherries = grid[r1][c1] + grid[r2][c2];

            dp[r1][c1][r2][c2] = cherries + Math.max(
                    Math.max(pickUp(grid, dp, r1 + 1, c1, r2 + 1, c2), pickUp(grid, dp, r1, c1 + 1, r2, c2 + 1)),
                    Math.max(pickUp(grid, dp, r1, c1 + 1, r2 + 1, c2), pickUp(grid, dp, r1 + 1, c1, r2, c2 + 1))
            );
        }

        return dp[r1][c1][r2][c2];
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    class Coordinate {
        int row;
        int col;
        Coordinate parent;

        public Coordinate(int row, int col, Coordinate parent) {
            this.row = row;
            this.col = col;
            this.parent = parent;
        }
    }

    int[][] directionsFromTopToBottom = {
            {0, 1},
            {1, 0}
    };

    int[][] directionsBottomToTop = {
            {0, -1},
            {-1, 0}
    };

    List<int[]> path = new ArrayList();
    Coordinate pathEnd = null;

    public int foo(int[][] grid) {
        int n = grid.length;
        if (grid[n - 1][n - 1] == -1 ||
                grid[0][0] == -1 ||
                !isReachable(grid, new int[]{0, 0})) return 0;

        // Find the maximum lot of the path
        int topToBottom = count(grid, new int[]{0, 0}, new int[]{n - 1, n - 1}, directionsFromTopToBottom);

        // Find the path with this lot
        pathFinder(grid, null, new int[]{0, 0}, new int[]{n - 1, n - 1}, 0, topToBottom);

        // Update the grid - free the nodes which have no cherries anymore
        while (pathEnd != null) {
            grid[pathEnd.row][pathEnd.col] = 0;
            pathEnd = pathEnd.parent;
        }

        // Find the lot from the bottom to top path
        int bottomToTop = count(grid, new int[]{n - 1, n - 1}, new int[]{0, 0}, directionsBottomToTop);

        // return the sum
        return topToBottom + bottomToTop;
    }

    private boolean isReachable(int[][] grid, int[] current) {
        if (current[0] == grid.length - 1 && current[1] == grid.length - 1) return true;
        if (inBounds(grid, current)) {
            if (grid[current[0]][current[1]] == -1) return false;
            return isReachable(grid, new int[]{current[0] + 1, current[1]}) ||
                    isReachable(grid, new int[]{current[0], current[1] + 1});
        }
        return false;
    }

    private void pathFinder(int[][] grid,
                            Coordinate parent,
                            int[] current,
                            int[] destination,
                            int path,
                            int lot) {

        if (current[0] == destination[0] &&
                current[1] == destination[1] &&
                path + grid[current[0]][current[1]] == lot
        ) {
            pathEnd = new Coordinate(current[0], current[1], parent);
        }

        if (inBounds(grid, current)) {
            if (grid[current[0]][current[1]] == -1) return;
            for (int[] direction : directionsFromTopToBottom) {
                int row = current[0] + direction[0];
                int column = current[1] + direction[1];
                pathFinder(
                        grid,
                        new Coordinate(current[0], current[1], parent),
                        new int[]{row, column},
                        destination,
                        path + grid[current[0]][current[1]], lot);
            }
        }
    }

    private int count(int[][] grid,
                      int[] current,
                      int[] destination,
                      int[][] directions) {
        if (current[0] == destination[0] && current[1] == destination[1])
            return grid[current[0]][current[1]];

        if (inBounds(grid, current)) {
            if (grid[current[0]][current[1]] == -1) return 0;

            int max = Integer.MIN_VALUE;
            for (int[] direction : directions) {
                int row = current[0] + direction[0];
                int column = current[1] + direction[1];
                max = Math.max(max, count(grid, new int[]{row, column}, destination, directions));
            }

            if (max == Integer.MAX_VALUE) return max;
            return grid[current[0]][current[1]] == 1 ? 1 + max : max;
        }

        return Integer.MIN_VALUE;
    }

    private boolean inBounds(int[][] grid, int[] current) {
        int n = grid.length;
        return current[0] >= 0 && current[0] < n && current[1] >= 0 && current[1] < n;
    }
}
