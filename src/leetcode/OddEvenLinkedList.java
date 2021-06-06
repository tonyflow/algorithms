package leetcode;

import lists.ListNode;

/**
 * Group all odd nodes followed by even nodes
 */
public class OddEvenLinkedList {

    static ListNode transform(ListNode head) {

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode grouped = OddEvenLinkedList.transform(head);
        System.out.println(grouped);
    }
}
