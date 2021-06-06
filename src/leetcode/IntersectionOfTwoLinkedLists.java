package leetcode;

import lists.ListNode;

public class IntersectionOfTwoLinkedLists {

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Find lengths
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        int diff = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB) {
            // Advance A
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            // Advance B
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private static int findLength(ListNode head) {
        ListNode traverse = head;
        int length = 0;
        while (traverse != null) {
            length++;
            traverse = traverse.next;
        }
        return length;
    }

    /**
     * The reversal of the first list messes up the second one
     */
    static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // Traverse to the end of the list
        ListNode reversedA = reverse(headA);
        ListNode reversedB = reverse(headB);
        ListNode intersection = null;

        while (reversedA == reversedB) {
            intersection = reversedA;
            reversedA = reversedA.next;
            reversedB = reversedB.next;
        }


        return intersection;
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {

            // Save next
            next = current.next;

            // Reverse
            current.next = previous;

            // Advance
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        System.out.println(getIntersectionNode(headA, headB));

    }
}
