package leetcode;

import lists.ListNode;

public class ReverseLinkedListII {

    static public ListNode reverseBetween(ListNode head, int left, int right) {

        // Between the endOfFirstHalf and the startOfSecondHalf lies the reversed part of the list

        // Find end of first half
        ListNode endOfFirstHalf = left > 1 ? head : null;
        int toLeft = 1;
        while (toLeft < left - 1) {
            endOfFirstHalf = endOfFirstHalf.next;
            toLeft++;
        }

        // Find start of second half
        ListNode startOfSecondHalf = head;
        int toRight = 1;
        while (toRight <= right) {
            startOfSecondHalf = startOfSecondHalf.next;
            toRight++;
        }

        // Find start of reversed
        ListNode current = head;
        ListNode previous;

        toLeft = left;
        while (toLeft > 1) {
            current = current.next;
            toLeft--;
        }

        // Reverse list
        ListNode next;
        ListNode endOfReversed = current;
        previous = null;
        while (current != startOfSecondHalf) {
            // save next
            next = current.next;

            // Reverse
            current.next = previous;

            // Update previous and current
            previous = current;
            current = next;
        }

        if (endOfFirstHalf == null) {
            head = previous;
            endOfReversed.next = startOfSecondHalf;
        } else if (startOfSecondHalf == null) {
            endOfFirstHalf.next = previous;
        } else {
            endOfFirstHalf.next = previous;
            endOfReversed.next = startOfSecondHalf;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseBetween(head, 2, 4);

    }
}
