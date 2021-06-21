package leetcode.topkfrequentelements;

import java.util.*;

public class TopKFrequentElements {

    /**
     * In order words this is quick select
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }


        int dindex = 0;
        int[] distinct = new int[counts.size()];
        for (Integer number : counts.keySet()) {
            distinct[dindex] = number;
            dindex++;
        }
        int N = distinct.length;
        qs(counts, distinct, 0, N - 1, k);
        return Arrays.copyOfRange(distinct, N - k, N);
    }

    private int partition(Map<Integer, Integer> counts,
                          int[] distinct,
                          int start,
                          int end) {

        int pivot = distinct[end];
        int i = start;

        for (int j = start; j <= end - 1; j++) {
            if (counts.get(distinct[j]) < counts.get(pivot)) {
                swap(distinct, i, j);
                i++;
            }
        }
        swap(distinct, i, end);
        return i;
    }

    private void qs(Map<Integer, Integer> counts,
                    int[] distinct,
                    int start,
                    int end,
                    int k) {

        if (start == end) return;

        int partitionIndex = partition(counts, distinct, start, end);

        if (partitionIndex < distinct.length - k) {
            qs(counts, distinct, partitionIndex + 1, end, k);
        } else if (partitionIndex > distinct.length - k) {
            qs(counts, distinct, start, partitionIndex - 1, k);
        } else {
            return;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public int[] pq(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(e -> -e.getValue()));

        int[] result = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : counts.entrySet()) {
            queue.add(pair);
        }

        while (k > 0) {
            result[k - 1] = queue.poll().getKey();
            k--;
        }
        return result;
    }

    public int[] usingMapAndModify(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        while (k > 0) {
            // Find max
            int maxCount = Integer.MIN_VALUE;
            Integer maxEntry = null;
            for (Map.Entry<Integer, Integer> numToCount : counts.entrySet()) {
                if (numToCount.getValue() > maxCount) {
                    maxCount = numToCount.getValue();
                    maxEntry = numToCount.getKey();
                }
            }
            counts.remove(maxEntry);
            result[k - 1] = maxEntry;
            k--;
        }

        return result;
    }
}
