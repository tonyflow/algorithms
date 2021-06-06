package leetcode;

import trees.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            boolean heightCondition = Math.abs(leftHeight - rightHeight) < 2;
            return heightCondition && isBalanced(root.right) && isBalanced(root.left);
        }
        return true;
    }

    int height(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(height(root.left), height(root.right));
        } else {
            return 0;
        }
    }
}
