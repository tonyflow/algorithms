package leetcode;

import java.util.Arrays;

public class MaximalSquare {


    static public int maximalSquareLessSpace(char[][] matrix) {

        // We only keep to keep track of the current and the previous row
        int[][] dp = new int[2][matrix[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        int result = 0;

        for (int i = 1; i < matrix.length + 1; i++) {
            System.out.println("Processing lines " + (i) + " and " + (i - 1));
            for (int j = 1; j < matrix[0].length + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i % 2][j] = Math.min(dp[i % 2][j - 1], Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
                    result = Math.max(dp[i % 2][j], result);
                    System.out.println("dp[" + i % 2 + "][" + j + "] = min(dp[" + i % 2 + "][" + (j - 1) + "],dp[" + (i - 1) % 2 + "][" + (j - 1) + "],dp[" + (i - 1) % 2 + "][" + j + "]) = " + dp[i % 2][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }

        return result * result;
    }

    static public int maximalSquare(char[][] matrix) {

        // We are creating a dp array of size matrix + 1 so that we can take care of the out of bounds cases
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

    static public int bruteForce(char[][] matrix) {
        // Identify the smallest dimension
        int dim = matrix.length > matrix[0].length ? matrix.length : matrix[0].length;


        int max = 0;
        // Move the square horizontally
        while (dim > 0) {
            for (int row = 0; row + dim < matrix.length + 1; row++) {
                for (int col = 0; col + dim < matrix[0].length + 1; col++) {
                    int size = 0;
                    boolean square = true;
                    for (int i = row; i < row + dim && square; i++) {
                        for (int j = col; j < col + dim && square; j++) {
                            if (matrix[i][j] == '0') square = false;
                            else size++;
                        }
                    }
                    if (square) max = Math.max(max, size);
                }
            }
            dim--;
        }

        return max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}};
//        char[][] matrix = {{'0', '1'}, {'1', '0'}};
//        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquareLessSpace(matrix));
    }
}
