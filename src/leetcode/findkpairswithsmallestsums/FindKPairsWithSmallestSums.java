package leetcode.findkpairswithsmallestsums;

import tries.Node;

import java.util.*;

public class FindKPairsWithSmallestSums {

    class Pair {
        int nums1Index;
        int nums2Index;

        Pair(int nums1Index, int nums2Index) {
            this.nums1Index = nums1Index;
            this.nums2Index = nums2Index;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(n -> nums1[n.nums1Index] + nums2[n.nums2Index]));
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            queue.add(new Pair(0, i));
        }

        while (!queue.isEmpty()) {
            Pair polled = queue.poll();
            List<Integer> oneOfTheAnswers = Arrays.asList(nums1[polled.nums1Index], nums2[polled.nums2Index]);
            result.add(oneOfTheAnswers);
            if (result.size() == k) {
                break;
            }

            if (polled.nums1Index < nums1.length - 1)
                queue.add(new Pair(polled.nums1Index + 1, polled.nums2Index));

        }

        return result;
    }
}
