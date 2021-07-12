package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[0][i]);
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            int firstRow = 0;
            int lastRow = m - 1;
            int firstColumn = 0;
            int lastColumn = n - 1;
            while (firstRow < lastRow && firstColumn < lastColumn) {
                for (int i = firstColumn; i < lastColumn; i++) {
                    result.add(matrix[firstRow][i]);
                }

                for (int i = firstRow; i < lastRow; i++) {
                    result.add(matrix[i][lastColumn]);
                }

                for (int i = lastColumn; i > firstColumn; i--) {
                    result.add(matrix[lastRow][i]);
                }

                for (int i = lastRow; i > firstRow; i--) {
                    result.add(matrix[i][firstColumn]);
                }

                firstRow++;
                lastRow--;
                firstColumn++;
                lastColumn--;
            }

            if (firstColumn == lastColumn && m != n) {
                for (int i = firstRow; i <= lastRow; i++) {
                    result.add(matrix[i][firstColumn]);
                }
            }

            if (firstRow == lastRow && m != n) {
                for (int i = firstColumn; i <= lastColumn; i++) {
                    result.add(matrix[firstRow][i]);
                }
            }

            if (m == n && m % 2 != 0) result.add(matrix[firstRow][firstColumn]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 13}
        };

        int[][] matrix2 = {
                {11, 12, 13},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix3 = {
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10},
                {11, 12, 13},
                {14, 15, 16}
        };

        int[][] equal = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] equalEven = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] oneRow = {
                {7, 8, 9, 13}
        };

        int[][] oneColumn = {
                {7},
                {8},
                {9},
                {10}
        };

        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
        System.out.println(spiralOrder(equal));
        System.out.println(spiralOrder(equalEven));
        System.out.println(spiralOrder(oneRow));
        System.out.println(spiralOrder(oneColumn));
    }
}
