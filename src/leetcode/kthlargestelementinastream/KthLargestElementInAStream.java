package leetcode.kthlargestelementinastream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.add(num);

            // Maintain queue size to k
            if (queue.size() > k) queue.poll();
        }

    }

    public int add(int val) {
        queue.add(val);
        // Maintain queue size to k
        if (queue.size() > k) queue.poll();
        return queue.peek();
    }
}
