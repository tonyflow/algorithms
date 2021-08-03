package leetcode;

import lists.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        ListNode dummy = new ListNode(0);

        while (current != null) {
            if (previous == null && current.next != null && current.val != current.next.val) {
                dummy.next = current;
                previous = current;
            } else if (current.next != null && current.val != current.next.val) {
                    previous.next = current;
            } else if (previous != null) {
                previous.next = null;
            }

            current = current.next;
        }

        return dummy.next;

    }

    public ListNode deleteDuplicatesExtraSpace(ListNode head) {

        if (head == null) return null;

        Map<Integer, Integer> counts = new HashMap<>();

        ListNode current = head;

        while (current != null) {
            counts.put(current.val, counts.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        current = head;
        ListNode dummy = new ListNode(0);

        ListNode previous = null;

        while (current != null) {
            if (previous == null && counts.get(current.val) == 1) {
                dummy.next = current;
                previous = current;
            } else if (counts.get(current.val) == 1) {
                previous.next = current;
                previous = current;
            } else if (previous != null) {
                previous.next = null;
            }
            current = current.next;
        }

        return dummy.next;

    }
}
