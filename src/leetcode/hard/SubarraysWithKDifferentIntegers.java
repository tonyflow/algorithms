package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int i = 0;
        int res = 0;
        Map<Integer, Integer> counts = new HashMap();
        for (int j = 0; j < nums.length; j++) {
            counts.put(nums[j], counts.getOrDefault(nums[j], 0) + 1);

            while (counts.size() > k) {
                counts.put(nums[i], counts.get(nums[i]) - 1);
                if (counts.get(nums[i]) == 0) counts.remove(nums[i]);
                i++;
            }
            if (counts.size() <= k) res += j - i + 1;
        }

        return res;
    }

    public int wrong(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap();
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
            if (counts.keySet().size() == k) result++;
            else if (counts.keySet().size() > k) {
                while (counts.keySet().size() != k) {
                    counts.put(nums[left], counts.get(nums[left]) - 1);
                    if (counts.get(nums[left]) > 0) result++;
                    if (counts.get(nums[left]) == 0) counts.remove(nums[left]);
                    left++;
                }
            }
            right++;
        }
        return result;
    }
}
