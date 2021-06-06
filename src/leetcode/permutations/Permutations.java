package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];//-10 to 10
        for (int i = 0; i < nums.length; i++) {
            doFind(nums, result, visited, new ArrayList<>(), i);
        }
        return result;
    }

    private void doFind(int[] nums,
                        List<List<Integer>> result,
                        boolean[] visited,
                        List<Integer> partialResult,
                        int position) {

        if (position >= 0 && position < nums.length) {

            partialResult.add(nums[position]);

            if (partialResult.size() == nums.length) {
                result.add(partialResult);
            } else {
                visited[position] = true;
                int toLeft = position - 1;
                int toRight = position + 1;
                while (toLeft >= 0) {
                    if (!visited[toLeft])
                        doFind(nums, result, visited, new ArrayList<>(partialResult), toLeft);
                    toLeft--;
                }


                while (toRight < nums.length) {
                    if (!visited[toRight])
                        doFind(nums, result, visited, new ArrayList<>(partialResult), toRight);
                    toRight++;
                }

                visited[position] = false;
            }
        }
    }
}
