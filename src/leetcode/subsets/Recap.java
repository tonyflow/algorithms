package leetcode.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Recap {

    static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        // Initialize the result with the empty set
        ArrayList<Integer> firstPart = new ArrayList<>();
        result.add(firstPart);

        for (int number : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> existing : result) {
                ArrayList<Integer> newSubset = new ArrayList<>(existing);
                newSubset.add(number);
                newSubsets.add(newSubset);
            }

            result.addAll(newSubsets);
        }

        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> subset : subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8})) {
            System.out.println(subset);
        }

        System.out.println("=========================");
//
//        for (List<Integer> subset : subsets(new int[]{0})) {
//            System.out.println(subset);
//        }
    }
}
