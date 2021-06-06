package leetcode;

import trees.TreeNode;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root != null) {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 && right == 0) return 1;
            else if (left == 0 && right != 0) {
                return 1 + right;
            } else if (left != 0 && right == 0) {
                return 1 + left;
            } else {
                return 1 + Math.min(right, left);
            }
//        if (root == null) return 0;
//        if (root.right == null && root.left == null) {
//            return 1;
//        } else if (root.right != null && root.left == null) {
//            return doFind(root.right);
//        } else if (root.right == null && root.left != null) {
//            return doFind(root.left);
//        } else {
//            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
//        }
        } else return 0;
    }

    private int doFind(TreeNode root) {
        if (root != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else return 0;
    }
}
