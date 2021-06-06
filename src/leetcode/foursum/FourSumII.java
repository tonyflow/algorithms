package leetcode.foursum;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] nums1,
                            int[] nums2,
                            int[] nums3,
                            int[] nums4) {

        Map<Integer, Integer> oneTwoSumsToCounts = new HashMap<>();
        Map<Integer, Integer> threeFourSumsToCounts = new HashMap<>();
        int total = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                oneTwoSumsToCounts.put(i + j, oneTwoSumsToCounts.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                threeFourSumsToCounts.put(i + j, threeFourSumsToCounts.getOrDefault(i + j, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> oneTwoSumToCount : oneTwoSumsToCounts.entrySet()) {
            for (Map.Entry<Integer, Integer> threeFourSumToCount : threeFourSumsToCounts.entrySet()) {
                if (oneTwoSumToCount.getKey() + threeFourSumToCount.getKey() == 0) {
                    total += oneTwoSumToCount.getValue() * threeFourSumToCount.getValue();
                }
            }
        }

        return total;
    }
}
