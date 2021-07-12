package leetcode.reverselinkedlist;

import lists.ListNode;

public class RecapII {

    static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head;

        while (current != null) {
            // save next
            next = current.next;

            // reverse
            current.next = previous;

            // update current and previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode reversed = reverse(head);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }

    }
}
