package leetcode;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumBinaryTreeWidth {

    Map<Integer, Integer> depthToPosition = new HashMap<>();
    int max = 0;

    public int getMax(TreeNode root) {
        doGet(root, 0, 1);
        return max;
    }

    private void doGet(TreeNode root, int depth, int position) {

        if (root == null) return;
        depthToPosition.putIfAbsent(depth, position);
        max = Math.max(max, position - depthToPosition.get(depth) + 1);
        doGet(root.left, depth + 1, 2 * position);
        doGet(root.right, depth + 1, 2 * position + 1);
    }


}
