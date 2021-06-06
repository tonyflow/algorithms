package leetcode.combinationsum;

import java.util.List;

public class Playground {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        for (List<Integer> result : combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7)) {
            System.out.println(result);
        }
    }
}
