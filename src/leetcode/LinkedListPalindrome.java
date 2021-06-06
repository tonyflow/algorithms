package leetcode;

import lists.ListNode;

import java.util.Stack;

public class LinkedListPalindrome {

    static boolean check(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Create reversed list
        while (current != null) {
            stack.push(new ListNode(current.val));
            current = current.next;
        }

        // Pop nodes and create new reversed list
        ListNode previous = stack.pop();
        ListNode reversed = previous;

        while (!stack.isEmpty()) {
            previous.next = stack.pop();
            previous = previous.next;
        }

        previous.next = null;

        while (head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        System.out.println(LinkedListPalindrome.check(head));
    }
}
