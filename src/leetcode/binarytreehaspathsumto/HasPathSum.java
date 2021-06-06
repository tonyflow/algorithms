package leetcode.binarytreehaspathsumto;

import trees.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class HasPathSum {

    boolean check(TreeNode root, int sum) {
        return doCheck(root, sum, 0);
    }

    private boolean doCheck(TreeNode root,
                            int sum,
                            int pathSum) {

        if (root != null) {
            if (root.left == null && root.right == null && sum == pathSum + root.val) {
                return true;
            } else {
                return doCheck(root.left, sum, pathSum + root.val) || doCheck(root.right, sum, pathSum + root.val);
            }
        } else {
            return false;
        }
    }
}
