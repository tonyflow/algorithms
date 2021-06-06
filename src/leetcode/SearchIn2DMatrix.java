package leetcode;

public class SearchIn2DMatrix {

    /**
     * There is a formula for converting 2D matrices into 1D arrays and vice versa
     * -- n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
     * -- an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     */
    static boolean searchByConverting2DMatrixInto1DArray(int[][] matrix, int target) {
        // the 1D array should contain m*n values so the end for BS is m*n -1
        int start = 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int end = rowNum * colNum - 1;

        while (start <= end) {
            int middleIn1D = (start + end) >>> 1;
            int middleValueIn2D = matrix[middleIn1D / colNum][middleIn1D % colNum];
            if (middleValueIn2D > target) {
                end = middleIn1D - 1;
            } else if (middleValueIn2D < target) {
                start = middleIn1D + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Complexity here is log(m)+log(n)
     */
    static boolean search(int[][] matrix, int target) {

        int cols = matrix[0].length;
        int rows = matrix.length;
        int lowRow = 0;
        int highRow = rows - 1;

        int lowCol = 0;
        int highCol = cols - 1;

        // Find row
        while (lowRow < highRow) {
            int middleRow = (lowRow + highRow + 1) >>> 1;
            if (matrix[middleRow][0] > target) {
                highRow = middleRow - 1;
            } else {
                lowRow = middleRow;
            }
        }


        // After finding row lowRow = highRow and this is the row where we can perform the final BS
        while (lowCol <= highCol) {
            int middleCol = (lowCol + highCol) >>> 1;
            if (matrix[lowRow][middleCol] > target) {
                highCol = middleCol - 1;
            } else if (matrix[lowRow][middleCol] < target) {
                lowCol = middleCol + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(search(matrix, 10));
    }
}
