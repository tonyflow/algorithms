package palantir;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberOfEqualRowsAfterKFlips {

    /**
     * Given an n*m Matrix of 'P' and 'T' characters, find the maximum number
     * of completely 'P' rows, after k column flips.
     * <p>
     * A column flip consists of taking one column in the matrix, and inverting
     * it's values (i.e. all 'P' to 'T' and all 'T' to 'P')
     * <p>
     * Here is an example matrix:
     * PPT
     * TPT
     * TTT
     * <p>
     * if k = 1, the optimal solution is:
     * PPP
     * TPP
     * TTP
     * and it should output 1.
     * <p>
     * The number of all 'P' rows is 1, once the algorithm completes.
     * <p>
     * The input for the above test case would be:
     * 3 3
     * PPT
     * TPT
     * TTT
     * 1
     * <p>
     * The output would be:
     * 1
     */
    static int brute(char[][] m, int flips) {

        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < m[0].length; i++) {
            char[] currentRow = m[i];

            int count = 0;
            for (char c : currentRow) {
                if (c == 'T') count++;
            }

            if (count == flips) {
                String key = new String(currentRow);
                if (counts.containsKey(key)) counts.replace(key, counts.get(key) + 1);
                else counts.put(key, 1);
            }
        }

        return Collections.max(counts.values());
    }

    private void invert(char[][] m, int col) {
        for (int i = 0; i < m[0].length; i++) {
            char element = m[i][col];
            if (element == 'P') element = 'T';
            else if (element == 'T') element = 'P';
            else throw new IllegalArgumentException();
        }
    }

    private boolean checkRowEquality(char[] row) {
        char reference = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] != reference) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'P','P','T'},
                {'T', 'P', 'T'},
                {'T','T','T'}
        };
        System.out.println(brute(matrix,3));
    }

}
