package leetcode.hard;

import trees.TreeNode;

public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        max = Math.max(max,
                Math.max(
                        root.val, // path end at current code
                        Math.max(
                                left + root.val, // path includes current node
                                Math.max(
                                        right + root.val, // path includes current node
                                        right + left + root.val // path's "root" is the current node
                                )
                        )
                )
        );

        // The upper levels of the recursion cannot form a path that has the current node as root and extends both from
        // left and right thus we need to pick between left and right. In the case though that both left and right are less
        // than zero then we should consider none of them: In that case the maximum path starts at the current node - that
        // is why we are comparing left and right with zero
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
