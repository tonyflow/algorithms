package leetcode.firsttwononoverlappingsubarrayseachwithtargetsum;

import java.util.*;

public class FirstTwoNonOverlappingSubArraysEachWithTargetSum {


    public int minSumOfLengths(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        int minLengthOfLeftSubArray = Integer.MAX_VALUE;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefix.put(sum, i);
        }

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (prefix.containsKey(sum - target)) {
                int lengthOfLeftSubArray = prefix.get(sum - target) - i;
                minLengthOfLeftSubArray = Math.min(minLengthOfLeftSubArray, lengthOfLeftSubArray);

            }

            if (prefix.containsKey(sum + target) && minLengthOfLeftSubArray != Integer.MAX_VALUE) {
                int lengthOfRightSubArray = prefix.get(sum + target) - i;
                result = Math.min(result, minLengthOfLeftSubArray + lengthOfRightSubArray);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // it is not wasy to add memoization in this one and it TLEs
    public int tle(int[] arr, int target) {
        if (arr.length < 2) return -1;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index <= arr.length - 2; index++) {
            PriorityQueue<Integer> lengths = new PriorityQueue();
            doFind(arr, index, target, new Stack<>(), new HashSet<>(), lengths);
            System.out.println(lengths.size());
            if (lengths.size() > 1) {
                int sum = lengths.poll() + lengths.poll();
                System.out.println("sum " + sum);
                min = Math.min(min, sum);
                System.out.println("min " + min);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void doFind(int[] arr,
                        int index,
                        int remainder,
                        Stack<Integer> partial,
                        HashSet<Integer> processed,
                        PriorityQueue<Integer> lengths) {

        if (remainder < 0) return;
        if (remainder == 0) {
            lengths.add(partial.size());
            processed.addAll(partial);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if ((partial.isEmpty() || (partial.peek() == i - 1)) && !processed.contains(i)) {
                partial.add(i);
                doFind(arr, i + 1, remainder - arr[i], partial, processed, lengths);
                partial.pop();
            }
        }
    }
}
