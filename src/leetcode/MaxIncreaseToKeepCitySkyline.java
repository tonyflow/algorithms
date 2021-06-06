package leetcode;

import java.util.Arrays;

public class MaxIncreaseToKeepCitySkyline {

    static int find(int[][] grid) {
        // Determine skyline from top/bottom/left/right
        int[] topBottomContour = new int[grid[0].length];
        int[] leftRightContour = new int[grid.length];


        // // Determine rows max
        for (int i = 0; i < grid.length; i++) {
            Integer max = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            leftRightContour[i] = max;
        }

        System.out.println(Arrays.toString(leftRightContour));
        // // Determine columns max
        for (int i = 0; i < grid[0].length; i++) {
            Integer max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            topBottomContour[i] = max;
        }

        System.out.println(Arrays.toString(topBottomContour));

        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += Math.min(topBottomContour[j], leftRightContour[i]) - grid[i][j];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] skyline = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        System.out.println(find(skyline));
    }
}
