package leetcode.findcompletetreenodes;

import trees.TreeNode;

public class CountCompleteTreeNodes {

    /**
     * Do not traverse the tree!
     */
    public int countNodes(TreeNode root) {

        if (root != null) {
            int leftSubtreeHeight = leftHeight(root);
            int rightSubtreeHeight = rightHeight(root);

            // In this case the subtree starting from root is a COMPLETE tree so
            // we can use the formula 2^height - 1 to find the number of nodes
            if (leftSubtreeHeight == rightSubtreeHeight) {
                return (1 << leftSubtreeHeight) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        } else {
            return 0;
        }
    }

    private int leftHeight(TreeNode root) {
        if (root != null) {
            // The tree is complete so the deepest leaves belong to left subtrees
            return 1 + leftHeight(root.left);
        } else return 0;
    }

    private int rightHeight(TreeNode root) {
        if (root != null) {
            // The tree is complete so the deepest leaves belong to left subtrees
            return 1 + rightHeight(root.right);
        } else return 0;
    }
}
