package leetcode.sumofleftleaves;

import trees.TreeNode;

public class SumOfLeftLeaves {


    public int find(TreeNode root) {
        if (root == null) return 0;

        int sumOfLeftLeaves = 0;

        if (root.left != null) {
            // Definition of a left leaf
            if (root.left.left == null && root.left.right == null) {
                sumOfLeftLeaves += root.left.val;
            } else {
                sumOfLeftLeaves += find(root.left);
            }
        }


        sumOfLeftLeaves += find(root.right);

        return sumOfLeftLeaves;
    }

}
