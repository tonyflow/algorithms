package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionByHeight {

    static public int[][] reconstructQueue(int[][] people) {

        ArrayList<int[]> result = new ArrayList<>(people.length);
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
//        for (int[] person : people) {
//            System.out.println(Arrays.toString(person));
//        }

        for (int[] person : people) {
            result.add(person[1],person);
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] test = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        // this can never be the case because the tallest person should never have
        // a person in front of him
        int[][] test0 = {
                {4, 3},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] result = reconstructQueue(test);

        for (int[] person : result) {
            System.out.println(Arrays.toString(person));
        }
    }
}
