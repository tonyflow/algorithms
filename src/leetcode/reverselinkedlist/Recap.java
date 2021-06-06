package leetcode.reverselinkedlist;

import lists.ListNode;

public class Recap {

    static ListNode reverse(ListNode head) {

        ListNode next = null;
        ListNode current = head;
        ListNode previous = null;


        while (current != null) {
            // Store next
            next = current.next;

            // Reverse
            current.next = previous;

            // Update previous
            previous = current;
            // Update current
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode reversed = reverse(head);
        System.out.println(reversed);

    }

}
