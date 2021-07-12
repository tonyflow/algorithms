package leetcode.swapnodesinpairs;

import lists.ListNode;

public class Recap {

    static ListNode swap(ListNode head) {

        if (head == null) return null;

        ListNode a = head;
        ListNode b = head.next;
        ListNode result = a.next;
        ListNode previous = null;

        while (b != null) {

            // Swap
            a.next = b.next;
            b.next = a;

            if (previous != null) {
                previous.next = b;
            }

            previous = a;

            // Advance pointers
            a = a.next;
            b = a != null ? a.next : null;
        }

        return result == null ? head : result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode swaped = swap(head);
        while (swaped != null) {
            System.out.println(swaped.val);
            swaped = swaped.next;
        }
    }
}
