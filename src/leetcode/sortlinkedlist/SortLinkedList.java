package leetcode.sortlinkedlist;

import lists.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class SortLinkedList {


    ListNode sort(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode slow = head; //middle
        ListNode fast = head;
        ListNode temp = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode leftSide = sort(head);
        ListNode rightSide = sort(slow);

        return merge(leftSide, rightSide);
    }


    private ListNode merge(ListNode a, ListNode b) {

        ListNode helper = new ListNode(0);
        ListNode current = helper;

        while (a != null || b != null) {
            if (a == null) {
                current.next = b;
                b = b.next;
            } else if (b == null) {
                current.next = a;
                a = a.next;
            } else {
                if (a.val > b.val) {
                    current.next = b;
                    b = b.next;
                } else {
                    current.next = a;
                    a = a.next;
                }
            }
            current = current.next;
        }

        return helper.next;

    }

    private ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle
    }
}
