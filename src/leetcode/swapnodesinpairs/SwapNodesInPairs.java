package leetcode.swapnodesinpairs;

import lists.ListNode;

public class SwapNodesInPairs {

    static ListNode swap(ListNode head) {
        ListNode a = head;
        ListNode b = head.next;
        ListNode result = head.next;
        ListNode previous = head;

        while (a != null) {

            // Update previous
            previous.next = b;

            // Swap
            a.next = b.next;
            b.next = a;

            // Move pointers
            previous = a;
            a = a.next;
            b = a == null ? null : a.next;
        }

        return result;
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
