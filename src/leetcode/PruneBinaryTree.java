package leetcode;

import trees.TreeNode;

/**
 * Every node's value in either 0 or 1. Return the same tree where every subtree not containing 1 has been removed.
 */
public class PruneBinaryTree {


    TreeNode prune(TreeNode root) {

        if (root == null) return null;
        containsOne(root);

        return root;
    }

    private boolean containsOne(TreeNode root) {
        boolean rightContains = containsOne(root.right);
        boolean leftContains = containsOne(root.left);

        if (!rightContains) root.right = null;
        if (!leftContains) root.left = null;

        return root.val == 1 || rightContains || leftContains;
    }


}
