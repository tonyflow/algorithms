package leetcode.convertsortedlisttobinarysearchtree;

import lists.ListNode;

public class Playground {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        convertSortedListToBinarySearchTree.sortedListToBST(head);
    }
}
