package leetcode;

import lists.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Odd number of nodes - move slow to the middle
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        ListNode reversed = reverse(slow);

        while (reversed != null) {
            if (reversed.val != head.val) return false;
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode reversed = new ListNode(0);
        ListNode reversedHead = reversed;
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            reversed.next = new ListNode(stack.pop().val);
            reversed = reversed.next;
        }

        return reversedHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
