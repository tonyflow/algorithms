package leetcode.sortlinkedlist;

import lists.ListNode;

public class Recap {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(middle);
        return merge(sortedFirstHalf, sortedSecondHalf);
    }


    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {

        ListNode current = new ListNode(0);
        ListNode result = current;
        ListNode traverseFirstHalf = firstHalf;
        ListNode traverseSecondHalf = secondHalf;

        while (traverseFirstHalf != null || traverseSecondHalf != null) {
            if (traverseFirstHalf == null) {
                current.next = traverseSecondHalf;
                traverseSecondHalf = traverseSecondHalf.next;
            } else if (traverseSecondHalf == null) {
                current.next = traverseFirstHalf;
                traverseFirstHalf = traverseFirstHalf.next;
            } else {
                // merge two
                if (traverseFirstHalf.val > traverseSecondHalf.val) {
                    current.next = traverseSecondHalf;
                    traverseSecondHalf = traverseSecondHalf.next;
                } else {
                    current.next = traverseFirstHalf;
                    traverseFirstHalf = traverseFirstHalf.next;
                }
            }
            current = current.next;
        }

        return result.next;
    }

    private ListNode findMiddle(ListNode firstHalf) {
        ListNode slow = firstHalf;
        ListNode fast = firstHalf;
        ListNode tmp = null;

        while (fast != null && fast.next != null) {
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tmp.next = null; // mark end of first half
        return slow;
    }
}
