package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixReshape {

    static public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        int size = rows * cols;
        if (r * c != size) return mat;

        int[][] transformed = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int oneDArrayIndex = i * size + j;
                transformed[oneDArrayIndex / r][oneDArrayIndex % c] = mat[i][j];
            }
        }

        return transformed;
    }

    static public int[][] matrixReshape3(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (r * c != rows * cols) return mat;

        int[][] transformed = new int[r][c];
        int tr = 0;
        int tc = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                transformed[tr][tc] = mat[i][j];
                tc++;
                if (tc == c) {
                    tc = 0;
                    tr++;
                }
            }
        }

        return transformed;
    }

    static public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (r * c != rows * cols) return mat;

        int[][] transformed = new int[r][c];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                q.add(mat[i][j]);
            }
        }

        for (int i = 0; i < transformed.length; i++) {
            for (int j = 0; j < transformed[0].length; j++) {
                transformed[i][j] = q.poll();
            }
        }

        return transformed;
    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 2},
                {3, 4}
        };

        matrixReshape3(test, 1, 4);
    }
}
