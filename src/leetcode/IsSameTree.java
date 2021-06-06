package leetcode;

import trees.TreeNode;

public class IsSameTree {

    public boolean isSameTree(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        else if (a != null && b != null) {
            if (a.val == b.val) {
                return isSameTree(a.left, b.left) && isSameTree(a.right,b.right);
            } else {
                return false;
            }
        } else {
            // either a or b is null the return false
            return false;
        }
    }
}
