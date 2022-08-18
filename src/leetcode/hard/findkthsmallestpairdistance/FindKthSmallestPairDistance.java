package leetcode.hard.findkthsmallestpairdistance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {


    /**
     * Brilliant solution using binary search
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];

        int left = min;
        int right = max;

        while (left < right) {
            int middle = (left + right) >>> 1;

            // Now check how many pairs with distance less or equal to middle
            // we can construct based our input array
            int nop = check(nums, middle);
            if (nop < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private int check(int[] nums, int distance) {
        int left;
        int right = 1;
        int numberOfPairs = 0;
        for (left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] - nums[left] <= distance) right++;
            right--;
            numberOfPairs += (right - left);
        }
        return numberOfPairs;
    }

    ////////////////////////////////////////////////

    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int tle(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Node> q = new PriorityQueue(Comparator.<Node>comparingInt(node -> nums[node.j] - nums[node.i]));
        for (int i = 0; i + 1 < nums.length; i++)
            q.offer(new Node(i, i + 1));


        Node result = null;
        while (k > 0) {
            result = q.poll();
            if (result.j + 1 < nums.length)
                q.offer(new Node(result.i, result.j + 1));

            k--;
        }

        return nums[result.j] - nums[result.i];
    }

    /**
     * Brute force with sorting
     */
    public int sortingDoNotTraverseEntireSolutionSpace(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> res = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
            int count = 0;
            for (int j = i + 1; count <= k && j < nums.length; j++, count++) {
                // The elements are sorted in increasing order so it does not make sense
                // for us to process k elements after i. After the diff will just keep
                // getting bigger
                q.offer(Math.abs(nums[j] - nums[i]));
            }

            res.addAll(q);
        }
        while (res.size() < k) res.poll();
        return res.peek();
    }

    /**
     * Straight brute force
     */
    public int brute(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[j] - nums[i]);
                q.offer(diff);
                if (q.size() == k) q.poll();
            }
        }

        return q.peek();
    }
}
