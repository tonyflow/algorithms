package leetcode.combinationsumiii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(new HashSet<>(), 1, n, k, result);
        return result;
    }

    private void traverse(HashSet<Integer> partial,
                          int start,
                          int remainder,
                          int k,
                          List<List<Integer>> result) {

        if (remainder == 0 && partial.size() == k) {
            result.add(new ArrayList<>(partial));
            return;
        }

        if (remainder <= 0) return;

        // Else
        for (int i = start; i < 10; i++) {
            if (!partial.contains(i)) {
                partial.add(i);
                traverse(partial, i + 1, remainder - i, k, result);
                partial.remove(i);
            }
        }
    }
}
