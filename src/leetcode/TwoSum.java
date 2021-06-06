package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (diffToIndex.containsKey(nums[i])) {
                return new int[]{diffToIndex.get(nums[i]), i};
            } else {
                int diff = target - nums[i];
                diffToIndex.put(diff, i);
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum.twoSumBrute(new int[]{1, 2, 3, 4, 5, 6, 7, 56, 8}, 9)));
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 56, 8}, 9)));
    }
}
