package leetcode.rangesumbst;

import trees.TreeNode;

public class RangeSumBST {

    int find(TreeNode root,
             int min,
             int max) {

        if (root != null) {
            if (root.val >= min && root.val <= max) {
                return root.val + find(root.right, min, max) + doFind(root.left, min, max);
            } else {
                return doFind(root.right, min, max) + find(root.left, min, max);
            }
        } else {
            return 0;
        }
//        return doFind(root, min, max);
    }

    private int doFind(TreeNode root,
                       int min,
                       int max) {
        if (root != null) {
            if (root.val >= min && root.val <= max) {
                return root.val + doFind(root.right, min, max) + doFind(root.left, min, max);
            } else {
                return doFind(root.right, min, max) + doFind(root.left, min, max);
            }
        } else {
            return 0;
        }
    }


}
