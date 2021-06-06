package leetcode.longestunivaluepath;

import trees.TreeNode;

/**
 * Check leet code submissions for more versions of the solution
 */
public class LongestUniValuePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longest(root, root.val);
        return max;
    }

    private int longest(TreeNode root,
                        int reference) {
        if (root != null) {
            int longestLeft = longest(root.left, root.val);
            int longestRight = longest(root.right, root.val);
            max = Math.max(max, longestLeft + longestRight);
            if (root.val == reference) {
//                int longestLeft = longest(root.left, reference);
//                int longestRight = longest(root.right, reference);
//                max = Math.max(max, longestLeft + longestRight);
                return 1 + Math.max(longestLeft, longestRight);
            } else {
//                int renewedTraversalLeft = longest(root.left, root.val);
//                int renewedTraversalRight = longest(root.right, root.val);
//                max = Math.max(max, renewedTraversalLeft + renewedTraversalRight);
//                longest(root.right, root.val);
                return 0;
            }
        }

        return 0;
    }


}
