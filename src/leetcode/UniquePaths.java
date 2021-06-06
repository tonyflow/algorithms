package leetcode;

public class UniquePaths {

    int find(int m, int n) {
        return doFind(0, 0, m, n);
    }

    private int doFind(int currentRow,
                       int currentColumn,
                       int m,
                       int n) {

        if (currentRow == m - 1 && currentColumn == n - 1) {
            return 1;
        } else if(currentRow > m-1 || currentColumn > n-1 ) {
            return 0;
        } else {
            return doFind(currentRow, currentColumn + 1, m, n) + doFind(currentRow + 1, currentColumn, m, n);
        }
    }
}
