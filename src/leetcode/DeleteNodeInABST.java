package leetcode;

import trees.TreeNode;

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, null, key);
    }

    private TreeNode delete(TreeNode root,
                            TreeNode parent,
                            int key) {
        if (root != null) {
            if (root.val == key) {
                return merge(root.left, root.right);
            } else {
                root.left = delete(root.left, root, key);
                root.right = delete(root.right, root, key);
                return root;
            }
        } else {
            return null;
        }
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (right != null) {
            TreeNode tmp = right.left;
            right.left = left;
            right.right = merge(null, right.right);
            return right;
        } else if (left != null) {
            TreeNode tmp = right.right;
            right.right = right;
            right.left = merge(right.left, null);
            return left;
        } else
            return null;
    }


}
