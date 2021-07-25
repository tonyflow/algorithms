package leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> partial = new Stack<>();
        Arrays.sort(candidates);
        traverse(candidates, 0, target, partial, result);
        return result;
    }

    private void traverse(int[] candidates,
                          int currentIndex,
                          int remainder,
                          Stack<Integer> partial,
                          List<List<Integer>> result) {
        if (remainder < 0) return;

        if (remainder == 0) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            // if we are at the first iteration or the current number has not been processed yet
            // since the array is sorted equal elements will be present in adjacent cells of the array
            if (i == currentIndex || candidates[i] != candidates[i - 1]) {
                partial.push(candidates[i]);
                traverse(candidates, i + 1, remainder - candidates[i], partial, result);
                partial.pop();
            }
        }
    }
}
