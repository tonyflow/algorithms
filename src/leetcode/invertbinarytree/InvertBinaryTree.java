package leetcode.invertbinarytree;

import trees.TreeNode;

public class InvertBinaryTree {

    TreeNode invert(TreeNode root) {

        doInvert(root);
        return root;
    }

    void doInvert(TreeNode root) {

        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            doInvert(root.left);
            doInvert(root.right);
        }
    }
}
