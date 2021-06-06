package leetcode;

import lists.ListNode;

public class AddTwoNumbers {

    // 2 -> 4 -> 3
    // 5 -> 6 -> 4
    static ListNode add(ListNode a, ListNode b) {

        int carry = 0;
        ListNode keeper = new ListNode(0);
        ListNode result = keeper;
        while (a != null && b != null) {
            int add = a.val + b.val + carry;
            keeper.next = new ListNode(add % 10);
            carry = add / 10;

            a = a.next;
            b = b.next;
            keeper = keeper.next;
        }

        while (a != null) {
            int add = a.val + carry;
            keeper.next = new ListNode(add % 10);
            carry = add / 10;
            a = a.next;
            keeper = keeper.next;
        }

        while (b != null) {
            int add = b.val + carry;
            keeper.next = new ListNode(add % 10);
            carry = add / 10;
            b = b.next;
            keeper = keeper.next;
        }

        if (carry != 0) keeper.next = new ListNode(carry);

        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        ListNode result = add(a, b);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
