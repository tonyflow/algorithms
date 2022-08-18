package leetcode.hard.maximumsumof3nonoverlappingsubarrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSumOf3NonOverlappingSubarrays {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        /**
         * Element at i contains the starting index of the subarray with the biggest sum between (0,i)
         */
        int[] posLeft = new int[n];

        /**
         * Element at i contains the starting index of the subarray with the biggest sum between (i+k,n);
         */
        int[] posRight = new int[n];

        /**
         * Prefix sum array
         */
        int[] sum = new int[n + 1];
        int[] answer = new int[3];

        // Create prefix sum array
        for (int i = 0; i < n; i++)
            sum[i + 1] = nums[i] + sum[i];

        // Construct the posLeft dp array
        // Here we are already setting our point of reference total = sum[k] - sum[0]
        // so we are comparing from index i + 1
        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            int subSum = sum[i + 1] - sum[i - k + 1];
            if (subSum > total) {
                posLeft[i] = i - k + 1;
                total = subSum;
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        // Construct postRight dp array
        posRight[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n - k]; i >= 0; i--) {
            int subSum = sum[i + k] - sum[i];
            if (subSum >= total) {
                posRight[i] = i;
                total = subSum;
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        // Try all possible combination for middle array
        int maxSum = Integer.MIN_VALUE;
        for (int i = k; i <= n - 2 * k; i++) {
            int left = posLeft[i - 1];
            int right = posRight[i + k];
            int leftSubArray = sum[left + k] - sum[left];
            int rightSubArray = sum[right + k] - sum[right];
            int middleSubArray = sum[i + k] - sum[i];
            int candidate = leftSubArray + rightSubArray + middleSubArray;
            if (candidate > maxSum) {
                maxSum = candidate;
                answer[0] = left;
                answer[1] = i;
                answer[2] = right;
            }
        }
        return answer;
    }

    /**
     * The complexity of the following solution is O(2^n*logk) where k is the number of elements which we would need
     * to insert in the priority queue
     * <p>
     * The totally brute force approach for this would be to have 3 nested loops and check all combinations of 3 non
     * overlapping sybArrays
     */

    PriorityQueue<int[]> queue;

    public int[] recursionWithPQ(int[] nums, int k) {

        Comparator<int[]> sumComparator = Comparator.comparingInt(a -> -sum(nums, a, k));
        Comparator<int[]> indexComparator = (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            } else return 0;
        };

        queue = new PriorityQueue(sumComparator.thenComparing(indexComparator));

        traverse(nums, 0, k, new ArrayList());

        return queue.poll();
    }

    private void traverse(int[] nums,
                          int index,
                          int k,
                          List<Integer> partial) {
        if (index == nums.length) return;

        if (partial.size() == 3) {
            int[] pR = new int[3];
            for (int i = 0; i < 3; i++) {
                pR[i] = partial.get(i);
            }
            queue.offer(pR);
            traverse(nums, index, k, new ArrayList());
        } else {
            // skip this index
            traverse(nums, index + 1, k, partial);

            // factor in this index
            if (index + k < nums.length) {
                partial.add(index);
                traverse(nums, index + k, k, partial);
                partial.remove(partial.size() - 1);
            }
        }
    }

    private int sum(int[] r, int[] starts, int size) {
        int total = 0;
        for (int start : starts) {
            for (int i = start; i < start + size; i++) {
                total += r[i];
            }
        }
        return total;
    }
}
