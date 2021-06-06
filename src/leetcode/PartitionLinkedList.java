package leetcode;

import lists.ListNode;

public class PartitionLinkedList {

    static ListNode partition(ListNode head, int pivot) {

        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;

        while (head != null) {
            if (head.val < pivot) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        before.next = afterHead.next;
        after.next = null; // terminate list - avoid circular traversal - endless loop

        return beforeHead.next;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(666);
        a.next = new ListNode(55);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(14);
        a.next.next.next.next = new ListNode(15);
        a.next.next.next.next.next = new ListNode(6);
        a.next.next.next.next.next.next = new ListNode(2);

        ListNode partitioned = PartitionLinkedList.partition(a, 7);

        while (partitioned != null) {
            System.out.println(partitioned.val);
            partitioned = partitioned.next;
        }
    }
}
