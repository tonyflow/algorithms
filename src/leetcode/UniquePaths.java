package leetcode;

import java.util.Arrays;

public class UniquePaths {

    int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return doFind(0, 0, m, n, memo);
    }

    private int doFind(int currentRow,
                       int currentColumn,
                       int m,
                       int n,
                       int[][] memo) {

        if (currentRow == m - 1 && currentColumn == n - 1) {
            return 1;
        } else if (currentRow > m - 1 || currentColumn > n - 1) {
            return 0;
        } else {
            if (memo[currentRow][currentColumn] == -1) {
                memo[currentRow][currentColumn] = doFind(currentRow + 1, currentColumn, m, n, memo) + doFind(currentRow, currentColumn + 1, m, n, memo);
            }
            return memo[currentRow][currentColumn];
        }
    }
}
