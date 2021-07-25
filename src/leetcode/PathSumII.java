package leetcode;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, new LinkedList<>(), 0, targetSum, result);
        return result;

    }

    private void traverse(TreeNode root,
                          LinkedList<Integer> path,
                          int pathSum,
                          int targetSum,
                          List<List<Integer>> result) {

        if (root == null) return;

        if (root.left == null && root.right == null && pathSum + root.val == targetSum) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.add(root.val);
        traverse(root.left, path, pathSum + root.val, targetSum, result);
        traverse(root.right, path, pathSum + root.val, targetSum, result);
        path.removeLast();

    }
}
