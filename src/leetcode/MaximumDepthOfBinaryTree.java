package leetcode;

import trees.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        } else {
            return 0;
        }
    }
}
