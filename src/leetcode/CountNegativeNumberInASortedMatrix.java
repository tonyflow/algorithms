package leetcode;

// N + M solution
public class CountNegativeNumberInASortedMatrix {

    static int countNegatives(int[][] grid) {

        int negatives = 0;

        // Do binary search for every row
        for (int i = 0; i < grid.length; i++) {
            // Find first negative number - target is zero then
            int start = 0;
            int M = grid[0].length;
            int end = M - 1;

            while (start <= end) {
                int middle = (end - start) / 2 + start;
                if (grid[i][middle] < 0) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            negatives += M - start;
        }
        return negatives;
    }

    static int bs(int[] test, int target) {
        int start = 0;
        int end = test.length - 1;

        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (test[middle] < 0) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(bs(new int[]{0, 0, 0, 0, 0, 0, -1, -2, -3}, 0));
        int result = countNegatives(new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        });
        System.out.println(result);
    }
}
