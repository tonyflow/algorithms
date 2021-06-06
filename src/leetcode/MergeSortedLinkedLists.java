package leetcode;

import lists.ListNode;

public class MergeSortedLinkedLists {

    static ListNode merge(ListNode a, ListNode b) {

        ListNode merged = new ListNode(Integer.MAX_VALUE);
        ListNode current = merged;

        while (a != null || b != null) {

            if (a == null) {
                current.next = b;
                b = b.next;
            } else if (b == null) {
                current.next = a;
                a = a.next;
            } else {
                if (a.val < b.val) {
                    current.next = a;
                    a = a.next;
                } else {
                    current.next = b;
                    b = b.next;
                }
            }

            current = current.next;
        }

        return merged.next;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(4);
        b.next = new ListNode(5);

        ListNode merged = MergeSortedLinkedLists.merge(a, b);

        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }
}
