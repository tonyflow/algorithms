package leetcode;

import lists.ListNode;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {

    static public void reorderList(ListNode head) {

        Map<ListNode, ListNode> previous = new HashMap<>();
        ListNode current = head;
        ListNode beforeCurrent = null;
        while (current != null) {
            previous.put(current, beforeCurrent);
            beforeCurrent = current;
            current = current.next;
        }

        // beforeCurrent is the last node
        ListNode start = head;
        ListNode end = beforeCurrent;
        ListNode next;

        ListNode p = null;
        while (start != end && start != previous.get(end)) {
            if (p != null) {
                p.next = start;

            }
            p = end;

            // Save next
            next = start.next;

            // Reorder
            start.next = end;

            // Update pointers
            start = next;
            end = previous.get(end);
        }


        // in the case of a even numbered list start.next == end
        // in the case of an odd numbered list start == end
        end.next = null;
        if (p != null) p.next = start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
