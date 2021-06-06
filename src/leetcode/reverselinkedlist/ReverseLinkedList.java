package leetcode.reverselinkedlist;

import lists.ListNode;

import java.util.Stack;

public class ReverseLinkedList {


    // 1 -> 2 -> 3 -> NULL
    // 3 -> 2 -> 1 -> NULL

    public ListNode reverse(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // Save next
            next = current.next;

            // Reverse
            current.next = previous;

            // Advance previous and current
            previous = current;
            current = next;
        }

        return previous;

    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversedListHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }

    static public ListNode reverseWithStack(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Push all nodes to the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // The stack now contains the nodes in reverse

        ListNode reversed = stack.pop();
        ListNode helper = reversed;
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            helper.next = next;
            helper = helper.next;
        }

        helper.next = null;

        return reversed;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLinkedList.reverseWithStack(head);
    }
}
