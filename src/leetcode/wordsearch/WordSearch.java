package leetcode.wordsearch;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && found(i, j, board, visited, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean found(int row,
                          int col,
                          char[][] board,
                          boolean[][] visited,
                          String word,
                          int index) {
        if (inBounds(row, col, board) && !visited[row][col] && board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            if (index == word.length() - 1) return true;
            boolean foundWord = found(row - 1, col, board, visited, word, index + 1) ||
                    found(row, col + 1, board, visited, word, index + 1) ||
                    found(row + 1, col, board, visited, word, index + 1) ||
                    found(row, col - 1, board, visited, word, index + 1);
            visited[row][col] = false;
            return foundWord;
        } else {
            return false;
        }
    }

    private boolean inBounds(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
