package leetcode.topkfrequentelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

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

    public int[] topKFrequent(int[] nums, int k) {
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
