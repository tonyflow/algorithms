package leetcode.medium;

import java.util.Arrays;

public class MinimumFallingPath {

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] m : memo) Arrays.fill(m, -1);
        for (int i = 0; i < matrix.length; i++)
            min = Math.min(min, traverse(matrix, 0, i, memo));
        return min;
    }

    private int traverse(int[][] matrix,
                         int i,
                         int j,
                         int[][] memo) {

        if (i == matrix.length - 1 && j >= 0 && j < matrix[0].length) return matrix[i][j];
        if (inBounds(matrix, i, j)) {
            if (memo[i][j] == -1) {
                // Diagonally left
                int diagonallyLeft = traverse(matrix, i + 1, j - 1, memo);
                // Diagonally right
                int diagonallyRight = traverse(matrix, i + 1, j + 1, memo);
                // Below
                int below = traverse(matrix, i + 1, j, memo);

                int min = Math.min(diagonallyLeft, Math.min(diagonallyRight, below));
                memo[i][j] = min == Integer.MAX_VALUE ? min : matrix[i][j] + min;
            }
            return memo[i][j];
        }
        return Integer.MAX_VALUE;
    }

    private boolean inBounds(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
