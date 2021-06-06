package leetcode.removenthnodefromendoflist;

import lists.ListNode;

public class RemoveNthElementFromTheEndOfLinkedList {

    static ListNode removeOptimal(ListNode head, int n) {

        if (head == null || head.next == null) return head;

        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i <= n; i++) {
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        a.next = a.next.next;

        return head;
    }

    static ListNode remove(ListNode head, int n) {

        if (head == null || head.next == null) return head;

        // Find length
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length += 1;
        }

        // Reset current to head and traverse until the nth element before the end
        // 1 2 3 4, n=1, length =4
        current = head;
        for (int i = 0; i < (length - n) - 1; i++) {
            current = current.next;
        }

        // Point the element after the one to be deleted
        // 1 2 3 4, n=1, length =4 - in that case null
        current.next = current.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(0);

//        ListNode clean = remove(head, 1);
        ListNode clean = removeOptimal(head, 1);

        while (clean != null) {
            System.out.println(clean.val);
            clean = clean.next;
        }
    }
}
