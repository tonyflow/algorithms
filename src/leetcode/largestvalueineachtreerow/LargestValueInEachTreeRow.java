package leetcode.largestvalueineachtreerow;

import trees.TreeNode;

import java.util.*;

public class LargestValueInEachTreeRow {

    List<Integer> find(TreeNode root) {

        Map<Integer, List<Integer>> valuesPerLevel = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        doFind(root, 0, valuesPerLevel);
        for (Map.Entry<Integer, List<Integer>> level : valuesPerLevel.entrySet()) {
            Optional<Integer> max = level.getValue().stream().max(Integer::compareTo);
            result.add(max.get());
        }

        return result;
    }

    private void doFind(TreeNode root,
                        int level,
                        Map<Integer, List<Integer>> valuesPerLevel) {
        if (root != null) {
            if (valuesPerLevel.containsKey(level)) {
                valuesPerLevel.get(level).add(root.val);
            } else {
                List<Integer> objects = new ArrayList<>();
                objects.add(root.val);
                valuesPerLevel.put(level, objects);
            }

            doFind(root.left, level + 1, valuesPerLevel);
            doFind(root.right, level + 1, valuesPerLevel);
        }

    }
}
