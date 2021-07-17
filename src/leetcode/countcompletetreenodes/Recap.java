package leetcode.countcompletetreenodes;

import trees.TreeNode;

public class Recap {

    public int countNodes(TreeNode root) {

        int heightRight = findHeightRight(root.right);
        int heightLeft = findHeightLeft(root.left);
        if (heightLeft == heightRight) return 1 << heightLeft - 1;
        else return 1 + countNodes(root.right) + countNodes(root.left);
    }

    private int findHeightLeft(TreeNode root) {
        if (root != null) {
            return 1 + findHeightLeft(root.left);
        } else return 0;
    }

    private int findHeightRight(TreeNode root) {
        if (root != null) {
            return 1 + findHeightRight(root.left);
        } else return 0;
    }
}
