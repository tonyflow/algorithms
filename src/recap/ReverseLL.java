package recap;

import lists.ListNode;

public class ReverseLL {

    static ListNode reverse(ListNode head) {

        ListNode previous = null;
        ListNode next;
        ListNode current = head;

        while (current != null) {
            // Store next
            next = current.next;

            // Reverse
            current.next = previous;

            // Update pointers
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
