package leetcode;

import lists.ListNode;

import java.util.HashSet;

public class LinkedListCycleII {

    public ListNode hasCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }

        return null;
    }
}
