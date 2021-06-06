package leetcode.findmodeinbst;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {

    Integer currentCount;
    Integer currentValue;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inOrder(root);
        currentCount = null;currentValue = null;
        findModes(root, result);

        if(result.size() == 0) return new int[]{0};
        int[] rr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            rr[i] = result.get(i);
        }
        return rr;
    }

    private void findModes(TreeNode root, List<Integer> result) {
        if (root != null) {
            findModes(root.left, result);
            // this is the first value we are visiting
            if (currentValue == null) {
                currentValue = root.val;
                currentCount = 1;
            } else if (root.val == currentValue) {
                currentCount++;
                if (currentCount == maxCount) result.add(root.val);
            } else {
                currentCount = 1;
                currentValue = root.val;
            }
            findModes(root.right, result);
        }
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            // this is the first value we are visiting
            if (currentValue == null) {
                currentValue = root.val;
                currentCount = 1;
            } else if (root.val == currentValue) {
                currentCount++;
            } else {
                currentCount = 1;
                currentValue = root.val;
            }
            maxCount = Math.max(maxCount, currentCount);
            inOrder(root.right);
        }
    }


    public int[] additionalSpace(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> valueToCount = new HashMap<>();
        traverse(root, valueToCount);

        // Find max
        int maxCount = 0;
        for (Integer value : valueToCount.values()) {
            maxCount = Math.max(maxCount, value);
        }

        // Find all other values that have frequency equal to max
        for (Map.Entry<Integer, Integer> entry : valueToCount.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == maxCount) result.add(key);
        }

        int[] rr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            rr[i] = result.get(i);
        }
        return rr;
    }

    private void traverse(TreeNode root, Map<Integer, Integer> valueToCount) {
        if (root != null) {
            valueToCount.put(root.val, valueToCount.getOrDefault(root.val, 0) + 1);
            traverse(root.left, valueToCount);
            traverse(root.right, valueToCount);
        }
    }

}
