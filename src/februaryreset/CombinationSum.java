package februaryreset;

import java.util.*;

public class CombinationSum {

    List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Stack<Integer> indices = new Stack<>();
        doFind(candidates, 0, 0, indices, target, result);

        return new ArrayList<>(result);
    }

    private void doFind(
            int[] candidates,
            int currentIndex,
            int currentSum,
            Stack<Integer> indices,
            int target,
            Set<List<Integer>> result
    ) {
        if (currentIndex == candidates.length || currentSum > target) return;

        if (currentSum == target) {
            List<Integer> partialResult = new ArrayList<>();
            for (Integer index : indices) {
                partialResult.add(candidates[index]);
            }
            result.add(partialResult);
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            indices.push(i);
            doFind(candidates,
                    currentIndex + 1,
                    currentSum + candidates[i],
                    indices,
                    target,
                    result);
            indices.pop();
        }
    }
}
