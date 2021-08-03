package leetcode;

import java.util.Arrays;

//[[1,4],[3,2]]
//[[10,20,15],[21,30,14],[7,16,32]]
//[[1,2,3,4,5,6,7,8],[2,3,4,5,6,7,8,9],[3,4,5,6,7,8,9,10],[4,5,6,7,8,9,10,11]]
public class FindPeakElementII {

    // Same as the below solution but doing BS on columns instead of rows
    static int[] col(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length - 1;

        while (startCol <= endCol) {
            int middleCol = startCol + endCol >>> 1;
            int maxRow = 0;
            int maxRowIndex = 0;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][middleCol] > maxRow) {
                    maxRowIndex = i;
                    maxRow = mat[i][middleCol];
                }
            }

            // Check if we found peak
            boolean isLeftElementBigger = middleCol - 1 > 0 ? mat[maxRowIndex][middleCol - 1] > mat[maxRowIndex][middleCol] : false;
            boolean isRightElementBigger = middleCol + 1 < mat[0].length ? mat[maxRowIndex][middleCol + 1] > mat[maxRowIndex][middleCol] : false;

            if (!isLeftElementBigger && !isRightElementBigger) {
                return new int[]{maxRowIndex, middleCol};
            } else if (isRightElementBigger) {
                startCol = middleCol + 1;
            } else {
                endCol = middleCol - 1;
            }

        }
        return new int[]{-1, -1};
    }

    // Same as the above solution but using rows instead of columns
    static int[] findPeakGrid(int[][] mat) {
        int startRow = 0;
        int endRow = mat.length - 1;

        while (startRow <= endRow) {
            int middleRow = startRow + endRow >>> 1;
            int maxCol = 0;
            int maxColIndex = 0;
            for (int i = 0; i < mat[0].length; i++) {
                if (mat[middleRow][i] > maxCol) {
                    maxColIndex = i;
                    maxCol = mat[middleRow][i];
                }
            }

            // Check if we found peak
            int potentialPeak = mat[middleRow][maxColIndex];
            int elementAbove = middleRow - 1 >= 0 ? mat[middleRow - 1][maxColIndex] : -1;
            int elementBelow = middleRow + 1 < mat.length ? mat[middleRow + 1][maxColIndex] : -1;
//            boolean isAboveElementBigger = middleRow - 1 > 0 ? mat[middleRow - 1][maxColIndex] > mat[middleRow][maxColIndex] : false;
//            boolean isBelowElementBigger = middleRow + 1 < mat.length ? mat[middleRow + 1][maxColIndex] > mat[middleRow][maxColIndex] : false;

            if (potentialPeak > elementAbove && potentialPeak > elementBelow) {
                return new int[]{middleRow, maxColIndex};
            } else if (elementBelow > potentialPeak) {
                startRow = middleRow + 1;
            } else {
                endRow = middleRow - 1;
            }

        }
        return new int[]{-1, -1};
    }

    static int[] moreComplex(int[][] mat) {

        // Search by row
        for (int i = 0; i < mat.length; i++) {
            int startCol = 0;
            int endCol = mat[i].length - 1;
            while (startCol < endCol) {
                int middle = startCol + endCol >>> 1;
                if (mat[i][middle] > mat[i][middle + 1])
                    endCol = middle;
                else
                    startCol = middle + 1;
            }

            if ((i == 0 && mat[i][startCol] > mat[i + 1][startCol]) ||
                    (i == mat.length - 1 && mat[i][startCol] > mat[i - 1][startCol]) ||
                    (i > 0 && i < mat.length - 1 && mat[i][startCol] > mat[i + 1][startCol] && mat[i][startCol] > mat[i - 1][startCol])
            )
                return new int[]{i, startCol};
        }

        // Search by col
        for (int i = 0; i < mat[0].length; i++) {
            int startRow = 0;
            int endRow = mat.length - 1;
            while (startRow < endRow) {
                int middle = startRow + endRow >>> 1;
                if (mat[i][middle] > mat[i][middle + 1])
                    endRow = middle;
                else
                    startRow = middle + 1;
            }

            if ((i == 0 && mat[startRow][i] > mat[startRow][i + 1]) ||
                    (i == mat.length - 1 && mat[startRow][i] > mat[startRow][i - 1]) ||
                    (i > 0 && i < mat.length - 1 && mat[startRow][i] > mat[startRow][i + 1] && mat[startRow][i] > mat[startRow][i - 1])
            )
                return new int[]{i, startRow};
        }


        return new int[]{-1, -1};

    }

    public static void main(String[] args) {
        //[[7,2,3,1,2],[6,5,4,2,1]]
        int[][] mat = {
                {7, 2, 3, 1, 2},
                {6, 5, 4, 2, 1}
        };
        //[[1,2,3,4,5,6,7,8],[2,3,4,5,6,7,8,9],[3,4,5,6,7,8,9,10],[4,5,6,7,8,9,10,11]]
        int[][] foo = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {2, 3, 4, 5, 6, 7, 8, 9},
                {3, 4, 5, 6, 7, 8, 9, 10},
                {4, 5, 6, 7, 8, 9, 10, 11}
        };

        int[][] error = {
                {48,36,35,17,48},
                {38,28,38,26,24},
                {15,9,33,32,6},
                {49,4,8,10,41}
        };
        System.out.println(Arrays.toString(findPeakGrid(error)));
    }

}
