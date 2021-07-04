package leetcode.partitionequalsubsetsum;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        Map<String, Boolean> memo = new HashMap<>();

        return partition(nums, 0, total, 0, memo);
    }

    private boolean partition(int[] nums,
                              int index,
                              int total,
                              int sum,
                              Map<String, Boolean> memo) {

        String memoKey = index + "" + sum;
        if (!memo.containsKey(memoKey)) {
            if (total - sum == sum) {
                return true;
            }
            if (sum > total / 2 || index == nums.length) return false;

            // DO take the number or DON'T take the number
            memo.put(memoKey, partition(nums, index + 1, total, sum + nums[index], memo)
                    || partition(nums, index + 1, total, sum, memo));
        }

        return memo.get(memoKey);
    }
}
