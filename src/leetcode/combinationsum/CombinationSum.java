package leetcode.combinationsum;

import java.util.*;

/**
 * Check the LC submissions for more versions of this solution - slower ones :)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        doFind(candidates, new Stack<>(), result, 0, target, 0);

        return new ArrayList<>(result);
    }

    private void doFind(int[] candidates,
                        Stack<Integer> partialCandidates,
                        Set<List<Integer>> result,
                        int partialSum,
                        int target,
                        int position) {

        if (position >= 0 && position < candidates.length) {

            if (partialSum == target) {
                result.add(new ArrayList<>(partialCandidates));
            } else if (partialSum < target) {
                // Candidates can be used over and over again so we have to traverse the entire array again
                for (int i = position; i < candidates.length; i++) {
                    int sum = partialSum + candidates[i];
                    partialCandidates.add(candidates[i]);
                    doFind(candidates, partialCandidates, result, sum, target, i);
                    partialCandidates.pop();
                }
            }
        }
    }
}
