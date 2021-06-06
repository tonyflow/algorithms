package leetcode;

public class SearchIn2DMatrixII {

    /**
     * Complexity here is log(m)+log(n)
     */
    static boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            // Found row
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                // Binary search the shit out out of this row
                int start = 0;
                int end = cols - 1;
                while (start <= end) {
                    int middle = (start + end) >>> 1;
                    if (matrix[i][middle] > target) {
                        end = middle - 1;
                    } else if (matrix[i][middle] < target) {
                        start = middle + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(search(matrix, 5));
    }

}
