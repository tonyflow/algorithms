package leetcode;

public class LargestIsland {

    public int findLargest(char[][] matrix) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, dfs(matrix, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(char[][] matrix, int i, int j) {
        if (inBounds(matrix, i, j) && matrix[i][j] == '1') {
            matrix[i][j] = '0';
            return 1 + dfs(matrix, i, j + 1) + dfs(matrix, i + 1, j) + dfs(matrix, i, j - 1) + dfs(matrix, i - 1, j);
        } else {
            return 0;
        }
    }

    private boolean inBounds(char[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
