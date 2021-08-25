package leetcode.hard;

import java.util.*;

public class SlidingWindowMaximum {

    class Pair {
        int number;
        int index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int getNumber() {
            return this.number;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        // We are keeping indexes of numbers
        // We keep the indexes of larger elements in the beginning of the queue
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements which are not in the current window
            while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();

            // Remove smaller elements than the current
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();

            q.offer(i);

            if (i >= k - 1) result.add(nums[q.peek()]);
        }


        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) r[i] = result.get(i);
        return r;
    }

    // 1,3,-1,-3,5,3,6,7
    public int[] nlogn(int[] nums, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(Pair::getNumber).reversed());
        List<Integer> result = new ArrayList<>();

        // Add the first k elements to the q
        for (int i = 0; i < k; i++) {
            q.offer(new Pair(nums[i], i));
        }

        // (3,1),(1,0),(-1,2)
        // result = {3}
        result.add(q.peek().number);

        for (int i = k; i < nums.length; i++) {
            // (3,1),(1,0),(-1,2),(-3,3)
            // (5,4),(3,1),(1,0),(-1,2),(-3,3)
            // (5,4),(3,5),(3,1),(1,0),(-1,2),(-3,3)
            q.offer(new Pair(nums[i], i));
            // The maximum in the queue is not contained in the current window
            while (q.peek().index < i - k + 1 || q.peek().index > i) {
                // then the maximum in the queue is not contained in a previous window
                // purge the maximum in the queue and continue
                q.poll();
            }
            // result = {3, 3}
            // result = {3, 3, 5}
            // result = {3, 3, 5, 5}
            result.add(q.peek().number);
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) r[i] = result.get(i);
        return r;
    }
}
