package leetcode;

import java.util.Arrays;

public class FlipColumnsForMaximumNumberOfEqualRows {

    static int flip(int[][] matrix) {
        int answer = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int[] row = matrix[i];
            int[] flipped = new int[row.length];
            for (int j = 0; j < row.length; j++) {
                flipped[j] = 1 - row[j];
            }

            int count = 0;
            for (int k = 0; k < matrix[0].length; k++) {
                if (Arrays.equals(row, matrix[k]) || Arrays.equals(flipped, matrix[k])) count++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {

    }

}
