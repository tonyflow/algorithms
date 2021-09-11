package leetcode.hard;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] memo = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                initMemo(memo);
                max = Math.max(max, traverse(matrix, visited, memo, i, j, Integer.MIN_VALUE));
            }
        }

        return max;
    }

    private void initMemo(int[][] memo) {
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
    }

    private int traverse(int[][] matrix,
                         boolean[][] visited,
                         int[][] memo,
                         int row,
                         int col,
                         int previous) {

        if (inBounds(matrix, row, col) && !visited[row][col] && matrix[row][col] > previous) {
            if (memo[row][col] == -1) {
                visited[row][col] = true;

                int[][] directions = {
                        {-1, 0},
                        {0, 1},
                        {1, 0},
                        {0, -1}
                };

                int max = 0;
                for (int i = 0; i < directions.length; i++) {
                    max = Math.max(max, traverse(matrix, visited, memo, row + directions[i][0], col + directions[i][1], matrix[row][col]));
                }

                visited[row][col] = false;
                memo[row][col] = 1 + max;
            }

            return memo[row][col];
        }

        return 0;
    }

    private boolean inBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
