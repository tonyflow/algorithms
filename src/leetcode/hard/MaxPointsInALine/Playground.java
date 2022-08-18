package leetcode.hard.MaxPointsInALine;

public class Playground {

    public static void main(String[] args) {
        MaxPointsInALine maxPointsInALine = new MaxPointsInALine();
        int[][] a = {
                {2, 3},
                {3, 3},
                {-5, 3}
        };
        int[][] b = {
                {0, 0},
                {1, 1},
                {1, -1}
        };

        int[][] c = {
                {1, 1},
                {2, 2},
                {3, 3}
        };
        maxPointsInALine.maxPoints(c);
    }
}
