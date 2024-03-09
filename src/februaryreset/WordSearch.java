package februaryreset;

import java.util.Arrays;

public class WordSearch {

    int[][] bounds = {
            {1, 0},
            {0, 1},
            {0, -1},
            {-1, 0},
    };

    boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (boolean[] v : visited) Arrays.fill(v, false);
        return doFind(board, 0, 0, visited, "", word);
    }

    private boolean doFind(char[][] board,
                           int i,
                           int j,
                           boolean[][] visited,
                           String wordSoFar,
                           String target) {

        if (wordSoFar.length() > target.length()) return false;

        if (wordSoFar.equals(target)) return true;

        boolean found = false;

        for (int k = 0; k < bounds[0].length && !found; k++) {
            visited[i][j] = true;
            doFind(board,
                    i + bounds[k][0],
                    j + bounds[k][1],
                    visited,
                    wordSoFar + board[i][j],
                    target);
            visited[i][j] = false;
        }

        return found;
    }
}
