package leetcode;

import lists.ListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode toBeDeleted = node.next;
        node.next = toBeDeleted.next;
        toBeDeleted.next = null;
    }
}
