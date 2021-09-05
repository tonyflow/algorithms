package leetcode.hard;

import lists.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode current = head;

        // Make sure there are enough nodes to reverse
        int group = k;
        while (current != null && group > 0) {
            current = current.next;
            group--;
        }

        if (group == 0) {

            // Reversal vars
            ListNode previous = null;
            current = head;
            ListNode next = null;
            group = k;

            while (group > 0) {

                // save next
                next = current.next;

                // reverse
                current.next = previous;

                // update previous and current
                previous = current;
                current = next;

                // update number of reversed nodes in group
                group--;
            }
            // head is now the last node of the reversed group
            // so its next pointer should point to the first node of the next
            // reversed group
            // The reversal of the next reversed group starts from node "next"
            head.next = reverseKGroup(next, k);
            return previous;
        } else {
            return head;
        }
    }


    private ListNode reverse(ListNode root) {
        ListNode previous = null;
        ListNode current = root;
        ListNode next;

        while (current != null) {

            // save next
            next = current.next;

            // reverse
            current.next = previous;

            // update previous and current
            previous = current;
            current = next;
        }

        return previous;
    }
}
