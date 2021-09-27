package leetcode.medium.rottingoranges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int days = 0;
        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        Queue<int[]> q = new LinkedList();
        // find rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        // Make sure we are only incrementing the days when  there were actually fresh oranges which
        // turned into rotten ones.
        while (!q.isEmpty()) {
            boolean didRot = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();
                for (int[] direction : directions) {
                    int row = polled[0] + direction[0];
                    int column = polled[1] + direction[1];
                    if (inBounds(grid, row, column) && grid[row][column] == 1) {
                        grid[row][column] = 2;
                        q.offer(new int[]{row, column});
                        didRot = true;
                    }
                }
            }
            if (didRot) days++;
        }

        // Check if all cells have been visited
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // There are still fresh oranges
                if (grid[i][j] == 1) return -1;
            }
        }
        return days;
    }

    private boolean inBounds(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
