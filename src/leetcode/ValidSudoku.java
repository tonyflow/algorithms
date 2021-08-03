package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // check rows
        for (int row = 0; row < board.length; row++) {
            Set<Character> rows = new HashSet<>();
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    if (board[row][col] < '1' || board[row][col] > '9') return false;
                    if (rows.contains(board[row][col])) return false;
                    rows.add(board[row][col]);
                }
            }
        }

        // check columns
        for (int col = 0; col < board[0].length; col++) {
            Set<Character> cols = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != '.') {
                    if (board[row][col] < '1' || board[row][col] > '9') return false;
                    if (cols.contains(board[row][col])) return false;
                    cols.add(board[row][col]);
                }
            }
        }

        // check submatrices
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                Set<Character> numbers = new HashSet<>();
                for (int coX = x; coX < x + 3; coX++) {
                    for (int coY = y; coY < y + 3; coY++) {
                        if (board[coX][coY] != '.') {
                            if (numbers.contains(board[coX][coY])) return false;
                            numbers.add(board[coX][coY]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
