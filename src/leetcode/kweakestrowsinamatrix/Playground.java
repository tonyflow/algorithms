package leetcode.kweakestrowsinamatrix;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        TheKWeakestRowsInAMatrix theKWeakestRowsInAMatrix = new TheKWeakestRowsInAMatrix();
        int[][] matrix = new int[][]{{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        int[] ints = theKWeakestRowsInAMatrix.kWeakestRowsOptimal(matrix, 3);
        System.out.println(Arrays.toString(ints));
    }
}
