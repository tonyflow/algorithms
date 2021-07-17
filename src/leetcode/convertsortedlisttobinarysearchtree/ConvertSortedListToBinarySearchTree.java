package leetcode.convertsortedlisttobinarysearchtree;

import lists.ListNode;
import trees.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        return split(head, null);
    }

    private TreeNode split(ListNode head, ListNode tail) {

        if (head != tail) {
            // slow will be the middle
            ListNode slow = head;
            // the fast pointer
            ListNode fast = head;

            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.val);
            root.left = split(head, slow);
            root.right = split(slow.next, tail);

            return root;
        } else return null;
    }
}
