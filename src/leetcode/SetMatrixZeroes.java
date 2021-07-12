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



    // m + n space complexity
    public void setZeroes(int[][] matrix) {

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
