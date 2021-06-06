package leetcode.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    // [1,2,3]
    // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    // You need the intuition to go with this one
    public List<List<Integer>> combine(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                List<Integer> helper = new ArrayList<>(curr);
                helper.add(num);
                newSubsets.add(helper);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public Set<Set<Integer>> combine2(int[] nums) {
        Set<Set<Integer>> results = new HashSet<>();
        results.add(new HashSet<>());
        for (int i = 0; i < nums.length; i++) {
            Set<Set<Integer>> subsets = new HashSet<>();
            for (int num : nums) {
                for (Set<Integer> result : results) {
                    Set<Integer> another = new HashSet<>(result);
                    another.add(num);
                    subsets.add(another);
                }
            }
            results.addAll(subsets);
        }
        return results;
    }

}
