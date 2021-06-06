package leetcode;

import trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> diffs = new HashSet<>();
        return doFind(root, k, diffs);
    }

    private boolean doFind(TreeNode root,
                           int k,
                           Set<Integer> diffs) {
        if (root != null) {
            if (diffs.contains(root.val)) return true;
            else {
                diffs.add(k - root.val);
                return doFind(root.left, k, diffs) || doFind(root.right, k, diffs);
            }
        }
        return false;
    }
}
