package leetcode.removenthnodefromendoflist;

import lists.ListNode;

public class Remove {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = dummy;

        for (int i = 0; i <= n; i++) {
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        a.next = a.next.next;

        return dummy.next;
    }
}
