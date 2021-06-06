package leetcode.diameteroftree;

import trees.TreeNode;

public class DiameterOfATree {

    int max = 0;

    int treeHeight(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
        } else {
            return 0;
        }
    }

    int diameterOfBinaryTree(TreeNode root) {

        // The diameter can be found by adding the maximum path from the left subtree
        // and the maximum path from the right subtree of the root
        findMaxPath(root);
        return max;

    }

    int findMaxPath(TreeNode root) {
        if (root != null) {
            int left = findMaxPath(root.left);
            int right = findMaxPath(root.right);

            max = Math.max(left + right, max);
            return 1 + Math.max(left, right);
        } else {
            return 0;
        }
    }
}
