package leetcode.MinimumHeightTrees;

public class Playground {

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int[][] test = {{1, 0}, {1, 2}, {1, 3}};
        int[][] a = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int[][] b = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        minimumHeightTrees.findMinHeightTrees(6, b);
    }
}
