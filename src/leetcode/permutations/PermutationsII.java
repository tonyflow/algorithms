package leetcode.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> partial = new ArrayList<>();
            Set<Integer> processed = new HashSet<>();
            partial.add(nums[i]);
            processed.add(i);
            traverse(nums, i, partial, processed, result);
        }

        return result.stream().collect(Collectors.toList());
    }

    private void traverse(int[] nums,
                          int index,
                          List<Integer> partial,
                          Set<Integer> processed,
                          Set<List<Integer>> result) {

        if (partial.size() == nums.length) {
            result.add(new ArrayList<>(partial));
        } else {
            // traverse right
            for (int i = 0; i < nums.length; i++) {
                if (!processed.contains(i)) {
                    processed.add(i);
                    partial.add(0, nums[i]);
                    traverse(nums, i, partial, processed, result);
                    partial.remove(0);
                    processed.remove(i);
                }

            }
        }

    }
}
