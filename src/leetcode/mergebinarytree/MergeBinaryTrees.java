package leetcode.mergebinarytree;

import trees.TreeNode;

public class MergeBinaryTrees {

    public TreeNode merge(TreeNode a, TreeNode b) {

        if (a != null && b != null) {
            a.val += b.val;
            a.left = merge(a.left, b.left);
            a.right = merge(a.right, b.right);
        } else if (a == null) {
            a = b;
        }

        return a;
    }
}
