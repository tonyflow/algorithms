package leetcode;

import lists.ListNode;

public class CyclicLinkedList {

    static boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && slow != null && fast.next != null) {
            if (fast == slow) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode startOfCycle = new ListNode(3);
        head.next.next = startOfCycle;
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = startOfCycle;
        head.next.next.next.next = new ListNode(5);

        System.out.println(CyclicLinkedList.hasCycle(head));
    }
}
