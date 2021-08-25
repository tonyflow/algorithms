package leetcode.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // 1,2,3,5,6,7
    // O(nlogn)
    public int longestConsecutive(int[] nums) {
        // Housekeeping
        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;

        // Sort
        Arrays.sort(nums);

        // Solve
        int localMaxLength = 1;
        int globalMaxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) localMaxLength++;
            else if (nums[i] == nums[i - 1]) continue;
            else {
                globalMaxLength = Math.max(globalMaxLength, localMaxLength);
                localMaxLength = 1;
            }
        }
        globalMaxLength = Math.max(globalMaxLength, localMaxLength);

        return globalMaxLength;
    }

    public int optimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 1;
        for (int num : nums)
            set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int localLongest = 0;
                int current = num;
                while (set.contains(current)) {
                    localLongest++;
                    current++;
                }
                result = Math.max(result, localLongest);
            }
        }

        return result;
    }
}
