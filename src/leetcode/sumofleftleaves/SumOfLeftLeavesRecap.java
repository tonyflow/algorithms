package leetcode.sumofleftleaves;

import sun.reflect.generics.tree.Tree;
import trees.TreeNode;

public class SumOfLeftLeavesRecap {


    int sum = 0;

    int sumOfLeftLeaves(TreeNode root) {
        accumulate(root.left, true);
        accumulate(root.right, false);
        return sum;
    }

    private void accumulate(TreeNode root, boolean isLeft) {
        if (root != null) {
            if (root.left == null && root.right == null && isLeft) {
                sum += root.val;
            } else {
                accumulate(root.left, true);
                accumulate(root.right, false);
            }
        }
    }

}
