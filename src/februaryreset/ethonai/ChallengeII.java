package februaryreset.ethonai;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ChallengeII {

    /**
     * ## Problem Statement
     * <p>
     * - Input: We have an array of `k` linked lists.
     * - Precondition: Each linked list is sorted (ascending order). Values are positive integers.
     * <p>
     * ## TASK
     * Merge all linked lists into one sorted linked list and return it.
     * <p>
     * ### Example
     * <p>
     * - Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * - Output: [1,1,2,3,4,4,5,6]
     * <p>
     * 1 -> 4 -> 5
     * // 45 -> 56 -> 100
     * 1 -> 3 -> 4
     * 2 -> 6
     * <p>
     * Node merge(List<Node> heads){
     * - Housekeeping
     * - input == empty
     * - input.length == 1 => return the head of the first list
     * - dummy head for the result
     * - dummy -> 1 -> 1 -> 2 -> 3
     * - skip the computation of local minimums for heads pointing to null
     * - termination condition
     * - all heads == null or
     * - processed all elememnts if k was the number of elements
     * - check the heads
     * - return dummy.next
     * }
     */

    public Node merge2(List<Node> heads) {
        Node dummy = new Node(Integer.MAX_VALUE);
        Node tail = dummy;

        Comparator<Node> c = (o1, o2) -> {
            if (o1.value < o2.value) {
                return -1;
            } else if (o1.value > o2.value) {
                return 1;
            } else return 0;
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(c);
        for (Node head : heads) {
            pq.add(head);
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) pq.add(tail.next);
        }
        return dummy.next;
    }

    public Node merge(List<Node> heads) {
        Node dummy = new Node(Integer.MAX_VALUE);
        Node previous = dummy;
        int minIndex = -1;
        boolean foundHead = false;

        /**
         * Create a TreeMap with a comparator based on the heads value
         */
//        while(!heads.isEmpty()){
//
//        }

        while (!allHeadsAreNull(heads)) {

            int localMin = Integer.MAX_VALUE;
            for (int i = 0; i < heads.size(); i++) {
                Node currentHead = heads.get(i);
                if (currentHead == null) continue;
                if (currentHead.value <= localMin) {
                    minIndex = i;
                    localMin = currentHead.value;
                }
            }

            previous.next = heads.get(minIndex);
            previous = previous.next;
            heads.set(minIndex, heads.get(minIndex).next);
        }

        return dummy.next;
    }

    private boolean allHeadsAreNull(List<Node> heads) {
        int count = 0;
        for (Node head : heads) {
            if (head == null) count++;
        }

        return count == heads.size();
    }
}
