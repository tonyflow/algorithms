package leetcode;

import lists.ListNode;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedList {
    static ListNode deleteDuplicates(ListNode head) {

        HashSet<Integer> unique = new HashSet<>();

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            if (unique.contains(current.val)) {
                // Delete node
                previous.next = current.next;
            } else {
                previous = current;
            }
            unique.add(current.val);
            current = current.next;

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        deleteDuplicates(head);
    }

}
