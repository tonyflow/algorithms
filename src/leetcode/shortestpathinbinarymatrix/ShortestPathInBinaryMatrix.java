package leetcode.shortestpathinbinarymatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        int[][] directions = {
                {-1, 0},// above
                {-1, 1},// upper right
                {0, 1},// right
                {1, 1},// lower right
                {1, 0},// below
                {1, -1},//lower left
                {0, -1},//left
                {-1, -1}// upper left
        };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();

                if (polled[0] == n - 1 && polled[1] == n - 1)
                    return result + 1;

                for (int[] direction : directions) {
                    int x = direction[0] + polled[0];
                    int y = direction[1] + polled[1];
                    if (inBounds(x, y, grid) && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
            result++;
        }
        return -1;
    }

    // Fails on this case
    //[
    //[0,0,1,0,0,0,0],
    //[0,1,0,0,0,0,1],
    //[0,0,1,0,1,0,0],
    //[0,0,0,1,1,1,0],
    //[1,0,0,1,1,0,0],
    //[1,1,1,1,1,0,1],
    //[0,0,1,0,0,0,0]
    //]
    public int almostRight(int[][] grid) {
        int[][] memo = new int[grid.length - 1][grid.length - 1];
        for (int[] m : memo)
            Arrays.fill(m, -1);
        int result = doSearch(grid, 0, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int doSearch(int[][] grid,
                 int sr,
                 int sc,
                 int[][] memo) {

        if (!inBounds(sr, sc, grid) || grid[sr][sc] == 1) return Integer.MAX_VALUE;

        if (sr == grid.length - 1 && sc == grid.length - 1)
            return 1;

        if (memo[sr][sc] == -1) {
            //int min = Integer.MAX_VALUE;
            grid[sr][sc] = 1;
            int above = doSearch(grid, sr - 1, sc, memo);
            int below = doSearch(grid, sr + 1, sc, memo);
            int left = doSearch(grid, sr, sc - 1, memo);
            int right = doSearch(grid, sr, sc + 1, memo);
            int minFourDirections = Math.min(above, Math.min(below, Math.min(left, right)));
            // Diagonals
            int upperLeft = doSearch(grid, sr - 1, sc - 1, memo);
            int upperRight = doSearch(grid, sr - 1, sc + 1, memo);
            int lowerLeft = doSearch(grid, sr + 1, sc - 1, memo);
            int lowerRight = doSearch(grid, sr + 1, sc + 1, memo);
            int minDiagonals = Math.min(upperLeft, Math.min(upperRight, Math.min(lowerLeft, lowerRight)));
            grid[sr][sc] = 0;
            if (minFourDirections == Integer.MAX_VALUE && minDiagonals == Integer.MAX_VALUE)
                memo[sr][sc] = minFourDirections; // or minDiagonals it's the same thing
            else
                memo[sr][sc] = 1 + Math.min(minFourDirections, minDiagonals);
        }
        return memo[sr][sc];
    }

    private static boolean inBounds(int row, int col, int[][] grid) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid.length - 1;
    }
}
