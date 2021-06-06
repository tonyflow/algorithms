package leetcode;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    public boolean badTimeComplexity(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int x = i;
                int y = j;
                int reference = matrix[x][y];
                while (x < rows && y < columns) {
                    if (matrix[x][y] != reference) return false;
                    x++;
                    y++;
                }
            }

        }

        return true;
    }

}
