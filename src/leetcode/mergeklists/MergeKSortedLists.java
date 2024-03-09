package leetcode.mergeklists;

import lists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;

        Comparator<ListNode> c = (o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val > o2.val) {
                return 1;
            } else
                return 0;
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<>(c);
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null)
                pq.add(tail.next);
        }
        return dummy.next;
    }
}
