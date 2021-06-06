package leetcode.subtreeofanothertree;

import trees.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root,
                             TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        else if (a != null && b != null) {
            if (a.val == b.val) {
                return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
            } else {
                return false;
            }
        } else {
            // either a or b is null the return false
            return false;
        }
    }
}
