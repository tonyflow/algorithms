package leetcode.hard;

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque();
        int[] prefix = new int[nums.length+1];

        for(int i = 0;i<nums.length;i++) prefix[i+1] = prefix[i]+nums[i];

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length+1;i++){
            while(!d.isEmpty() && prefix[i]-prefix[d.getFirst()]>=k)
                min = Math.min(min,i-d.pollFirst());
            while(!d.isEmpty() && prefix[i]<=prefix[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    public int wrong(int[] nums, int k) {
        TreeMap<Integer, PriorityQueue<Integer>> helper = new TreeMap();
        PriorityQueue<Integer> zero = new PriorityQueue(Comparator.reverseOrder());
        zero.offer(-1);
        helper.put(0, zero);

        int runningSum = 0;
        int min = Integer.MAX_VALUE;

        // 2,-1,2  and
        //
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int diff = runningSum - k;
            // returns the greatest key less than or equal
            Integer candidate = helper.floorKey(diff);
            if (candidate != null) {
                min = Math.min(min, i - helper.get(candidate).peek());
            }

            // Update helper
            helper.putIfAbsent(runningSum, new PriorityQueue<>(Comparator.reverseOrder()));
            PriorityQueue<Integer> update = helper.get(runningSum);
            update.offer(i);
            helper.put(runningSum, update);
        }

        return min == Integer.MAX_VALUE?-1:min;
    }

    public int doesNotWorkBecauseOfNegativeNumbers(int[] nums, int k) {

        int left = 0;
        int windowSum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= k && left <= right) {
                result = Math.min(result, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
