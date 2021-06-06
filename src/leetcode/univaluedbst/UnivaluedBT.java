package leetcode.univaluedbst;

import trees.TreeNode;

public class UnivaluedBT {

    boolean check(TreeNode head) {
        return doCheck(head, head.val);
    }

    private boolean doCheck(TreeNode head,
                            int reference) {
        if (head != null) {
            return head.val == reference && doCheck(head.left, reference) && doCheck(head.right, reference);
        }
        return true;
    }
}
