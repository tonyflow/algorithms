package leetcode;

import trees.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    Integer currentMin = Integer.MAX_VALUE;
    Integer previousVal = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return currentMin;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root.left);
            if (previousVal != null) {
                currentMin = Math.min(currentMin, Math.abs(previousVal - root.val));
            }
            previousVal = root.val;
            getMinimumDifference(root.right);
        }
    }
}
