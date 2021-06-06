package leetcode;

import java.util.*;

public class DegreeOfAnArray {

    static int findShortestSubArray(int[] nums) {
        int[] counts = new int[50_001];
        Arrays.fill(counts, 0);
        for (int num : nums) {
            counts[num]++;
        }


        int degree = 0;
        for (int i = 0; i < counts.length; i++) {
            degree = Math.max(counts[i], degree);
        }

        if (degree == 1) return 1;

        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == degree) candidates.add(i);
        }

        int minLength = Integer.MAX_VALUE;
        for (Integer candidate : candidates) {
            Integer start = null;
            Integer end = null;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidate && start == null) {
                    start = i;
                } else if (nums[i] == candidate) {
                    end = i;
                }
            }
            minLength = Math.min(minLength, end - start + 1);
        }


        return minLength;

    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
