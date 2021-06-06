package leetcode;

import trees.TreeNode;

public class SymmetricTree {

    boolean check(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return a.val == b.val && check(a.left, b.right) && check(a.right, b.left);
        }
    }

}
