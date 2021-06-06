package leetcode;

import lists.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {

        int number = 0;
        int order = -1;
        ListNode traverse = head;

        // Find length
        while (traverse != null) {
            order++;
            traverse = traverse.next;
        }


        while (head != null) {
            number += head.val * Math.pow(2, order);
            head = head.next;
            order--;
        }

        return number;
    }
}
