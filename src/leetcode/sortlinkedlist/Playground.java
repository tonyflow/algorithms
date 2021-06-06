package leetcode.sortlinkedlist;

import lists.ListNode;

public class Playground {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(0);


        SortLinkedList sortLinkedList = new SortLinkedList();
        ListNode sorted = sortLinkedList.sort(head);

        while (sorted != null) {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }
    }
}
