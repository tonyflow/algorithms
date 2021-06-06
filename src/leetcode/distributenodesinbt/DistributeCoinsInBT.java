package leetcode.distributenodesinbt;

import trees.TreeNode;

/**
 * This problem is so hard it makes it laugh. Here's a graphical representation for it
 * - https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
 */
public class DistributeCoinsInBT {

    int answer = 0;

    int find(TreeNode head) {
        traverse(head);
        return answer;
    }

    private int traverse(TreeNode head) {
        if (head != null) {
            int L = traverse(head.left);
            int R = traverse(head.right);
            answer += Math.abs(L) + Math.abs(R);
            return head.val + L + R - 1;
        } else return 0;
    }
}
