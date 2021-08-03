package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Fill marked rows with zero
        // The first row and first column contains sentinel values, so we would have to take care of this separately
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Fill marked columns with zero
        // The first row and first column contains sentinel values, so we would have to take care of this separately
        for (int j = 1; j < matrix[0].length;j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length;i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // check if the first row and column needs to be to zero too


    }

    // m + n space complexity
    public void extraSpace(int[][] matrix) {

        List<Coordinate> zeros = new ArrayList<>();

        //Find
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) zeros.add(new Coordinate(i, j));
            }
        }

        for (Coordinate zero : zeros) {
            // Zero-fy column
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zero.y] = 0;
            }

            // Zero-fy row
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[zero.x][i] = 0;
            }
        }
    }

    // TODO: 11.07.21 O(1) complexity ???
}
