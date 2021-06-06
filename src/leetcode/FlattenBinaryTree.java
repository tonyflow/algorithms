package leetcode;

import trees.TreeNode;

public class FlattenBinaryTree {

    void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        if (root.left != null) {
            flatten(root.left);
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode current = root.right;
            while (current.right != null) current = current.right;
            current.right = tmp;
        }

        if (root.right != null) {
            flatten(root.right);
        }
    }
}
