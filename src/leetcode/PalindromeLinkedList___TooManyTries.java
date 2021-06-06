package leetcode;

import lists.ListNode;

import java.util.Stack;

public class PalindromeLinkedList___TooManyTries {

    static boolean isPalindrome(ListNode head) {

        if (head != null) {
            ListNode slow = head;
            ListNode fast = head;

            int length = findLength(head);

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (length % 2 == 0) {
                // In the case of even number of nodes the slow pointer will point to the
                // start of the second half of the palindrome

                // We do not have to advance the slow pointer then
            } else {
                // In case of odd number of nodes the slow pointer will point to the
                // middle of the list so we have to advance it one more position
                slow = slow.next;

            }

            ListNode reversed = reverse(slow);

            while (reversed != null) {
                if (head.val != reversed.val) {
                    return false;
                }
                head = head.next;
                reversed = reversed.next;
            }

            return true;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode reversed = new ListNode(0);
        ListNode reversedHead = reversed;

        ListNode current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            reversed.next = stack.pop();
            reversed = reversed.next;
        }

        return reversedHead.next;
    }


    private static int findLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    /**
     * This one actually changes the structure of the list
     */
    private ListNode reverse2(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // Save next
            next = current.next;

            // Reverse
            current.next = previous;

            // Advance current and previous
            previous = current;
            current = next;
        }

        return previous;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}

