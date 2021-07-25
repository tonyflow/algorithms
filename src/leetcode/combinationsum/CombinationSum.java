package leetcode.combinationsum;

import sun.awt.X11.XStateProtocol;

import java.util.*;

/**
 * Check the LC submissions for more versions of this solution - slower ones :)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        doFind2(candidates, new Stack<>(), result, target, 0);

        return new ArrayList<>(result);
    }

    private void doFind2(int[] candidates,
                         Stack<Integer> partialCandidates,
                         Set<List<Integer>> result,
                         int remainder,
                         int position) {

        if (remainder < 0) return;
        else if (remainder == 0) {
            result.add(new ArrayList<>(partialCandidates));
        } else {
            for (int i = position; i < candidates.length; i++) {
                partialCandidates.push(candidates[i]);
                doFind2(candidates, partialCandidates, result, remainder - candidates[i], i);
                partialCandidates.pop();
            }
        }

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
