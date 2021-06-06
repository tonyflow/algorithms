package leetcode.subsets;

import java.util.List;

public class Playground {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
//        List<List<Integer>> combinations = subsets.combine(new int[]{1, 2, 3});
//        for (List<Integer> combination : combinations) {
//            System.out.println(combinations);
//        }
        List<List<Integer>> combinations = subsets.combine(new int[]{1, 2, 3});
//        Set<Set<Integer>> combinations = subsets.combine2(new int[]{1, 2, 3});
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
