package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsII {

    static public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<LinkedList<Integer>> result = new HashSet<>();
        LinkedList<Integer> initial = new LinkedList<>();
        result.add(initial);

        for (int i = 0; i < nums.length; i++) {
            Set<LinkedList<Integer>> iteration = new HashSet<>();
            for (LinkedList<Integer> partial : result) {
                LinkedList<Integer> helper = new LinkedList<>(partial);
                helper.add(nums[i]);
                Collections.sort(helper);
                iteration.add(helper);
            }

            result.addAll(iteration);
        }

        return result.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2};
        System.out.println(subsetsWithDup(test));
    }
}
