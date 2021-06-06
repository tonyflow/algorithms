package leetcode.checkarrayformationthroughconcatenation;

public class Playground {

    public static void main(String[] args) {
        CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();
//        int[] arr = {49, 18, 16};
//        int[][] pieces = {{16, 18, 49}};
        int[] arr = {1, 2, 3};
        int[][] pieces = {{2}, {1, 3}};
        checkArrayFormationThroughConcatenation.canFormArray(arr, pieces);
    }
}
