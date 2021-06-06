package leetcode;

import lists.ListNode;

public class ReorderLinkedList {

    static ListNode reorder(ListNode head) {

        // find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = null;

        while (fast != null && fast.next != null) {
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tmp.next = null;

        ListNode reversedSecondHalf = reverse(slow);

        // Merge first half and second half
        ListNode reordered = new ListNode(0);
        ListNode traverseReordered = reordered;
        while (head != null || reversedSecondHalf != null) {
            if (head == null) {
                traverseReordered.next = reversedSecondHalf;
                reversedSecondHalf = reversedSecondHalf.next;
                traverseReordered = traverseReordered.next;
            } else if (reversedSecondHalf == null) {
                traverseReordered.next = head;
                head = head.next;
                traverseReordered = traverseReordered.next;
            } else {
                traverseReordered.next = head;
                head = head.next;
                traverseReordered = traverseReordered.next;
                traverseReordered.next = reversedSecondHalf;
                reversedSecondHalf = reversedSecondHalf.next;
                traverseReordered = traverseReordered.next;
            }

        }


        return reordered.next;
    }

    private static ListNode reverse(ListNode slow) {
        // reverse second half
        ListNode previous = null;
        ListNode next = null;
        ListNode currentReversed = slow;

        while (currentReversed != null) {
            // Save next
            next = currentReversed.next;

            // Reverse
            currentReversed.next = previous;

            // Update pointers - previous and current
            previous = currentReversed;
            currentReversed = next;
        }

        // At the end, the prevoius is going to point to the beginning of the reversed second half

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorder(head);
    }
}
