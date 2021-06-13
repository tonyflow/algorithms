package leetcode;

public class RotateImage {

    static public void transposeAndReverse(int[][] matrix) {
        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // Reflect
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix.length - 1;
            while (start < end) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }

        System.out.println("we've made it");
    }

    static public void rotate(int[][] matrix) {
        int upperLimit = 0;
        int N = matrix.length - 1;
        int lowerLimit = N;
        int leftLimit = 0;
        int rightLimit = N;

        while (upperLimit < lowerLimit && leftLimit < rightLimit) {
            for (int j = 0; j < lowerLimit - upperLimit; j++) {
                int lastValue = matrix[upperLimit][leftLimit];
                // left to right
                for (int i = leftLimit + 1; i <= rightLimit; i++) {
                    int tmp = matrix[upperLimit][i];
                    matrix[upperLimit][i] = lastValue;
                    lastValue = tmp;
                }

                // up to down
                for (int i = upperLimit + 1; i <= lowerLimit; i++) {
                    int tmp = matrix[i][rightLimit];
                    matrix[i][rightLimit] = lastValue;
                    lastValue = tmp;
                }

                // right to left
                for (int i = rightLimit - 1; i >= leftLimit; i--) {
                    int tmp = matrix[lowerLimit][i];
                    matrix[lowerLimit][i] = lastValue;
                    lastValue = tmp;

                }

                // down to up
                for (int i = lowerLimit - 1; i >= upperLimit; i--) {
                    int tmp = matrix[i][leftLimit];
                    matrix[i][leftLimit] = lastValue;
                    lastValue = tmp;
                }

            }
            upperLimit++;
            lowerLimit--;
            leftLimit++;
            rightLimit--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

//        rotate(matrix2);
        transposeAndReverse(matrix2);
    }
}
