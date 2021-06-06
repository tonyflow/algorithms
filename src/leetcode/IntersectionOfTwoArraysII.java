package leetcode;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        int[] minCounts = new int[1001];
        Arrays.fill(minCounts, Integer.MAX_VALUE);

        updateGlobals(nums1, minCounts);
        updateGlobals(nums2, minCounts);

        for (int i = 0; i < minCounts.length; i++) {
            while (minCounts[i] > 0) {
                result.add(i);
                minCounts[i]--;
            }
        }

        int[] wrapper = new int[result.size()];
        for (int i = 0; i < wrapper.length; i++) {
            wrapper[i] = result.get(i);
        }
        return wrapper;
    }

    private void updateGlobals(int[] nums, int[] minCounts) {
        int[] counts = new int[1001];
        Arrays.fill(counts, 0);
        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i < minCounts.length; i++) {
            minCounts[i] = Math.min(minCounts[i], counts[i]);
        }
    }
}
