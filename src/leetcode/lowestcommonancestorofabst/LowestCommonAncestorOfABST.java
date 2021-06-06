package leetcode.lowestcommonancestorofabst;

import trees.TreeNode;

public class LowestCommonAncestorOfABST {

    TreeNode lcaBST(TreeNode root,
                    TreeNode p,
                    TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val > p.val && root.val > q.val) {
            return lcaBST(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lcaBST(root.right, p, q);
        } else {
            return root;
        }
    }
}
