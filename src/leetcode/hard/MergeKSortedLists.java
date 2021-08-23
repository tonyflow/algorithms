package leetcode.hard;

import lists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    class Pair {
        ListNode node;
        int index;

        public Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

        int getValue() {
            return this.node.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode resultTraverser = result;
        ListNode[] traversers = new ListNode[lists.length];
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(Pair::getValue));

        // Initialize traversers
        for (int i = 0; i < lists.length; i++) {
            traversers[i] = lists[i];
        }

        // Put first elements of every list into the priority queue
        for (int i = 0; i < lists.length; i++) {
            if (traversers[i] != null)
                q.offer(new Pair(traversers[i], i));
        }

        while (!q.isEmpty()) {
            Pair polled = q.poll();
            resultTraverser.next = polled.node;
            resultTraverser = resultTraverser.next;
            if (traversers[polled.index].next != null) {
                q.offer(new Pair(traversers[polled.index].next, polled.index));
                traversers[polled.index] = traversers[polled.index].next;
            }

        }
        return result.next;
    }
}
