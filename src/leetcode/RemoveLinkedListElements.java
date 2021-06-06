package leetcode;

import lists.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode previous = null;
        ListNode current = head;

        // Ignore initial nodes
        while (current != null && current.val == val) {
            current = current.next;
        }

        ListNode newHead = current;

        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return newHead;
    }
}
