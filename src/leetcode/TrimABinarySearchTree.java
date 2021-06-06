package leetcode;

import trees.TreeNode;

public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root,
                            int low,
                            int high) {

        if (root != null) {
            if (root.val >= low && root.val <= high) {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            } else {
                if (root.val < low) {
                    return trimBST(root.right, low, high);
                } else {
                    //(root.val > high)
                    return trimBST(root.left, low, high);
                }
            }
        }

        return root;
    }
}
