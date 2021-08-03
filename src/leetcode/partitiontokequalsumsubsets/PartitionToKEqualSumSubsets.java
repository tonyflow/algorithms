package leetcode.partitiontokequalsumsubsets;

import java.util.*;

public class PartitionToKEqualSumSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {

        boolean found;
        Arrays.sort(nums);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (sum % k != 0 || sum / k < max) return false;

        Set<Integer> processed = new HashSet<>();
        Set<Integer> processing = new HashSet<>();
        found = traverse(nums, 0, sum / k, sum / k, k, processed, processing);

        return found;
    }

    private boolean traverse(int[] nums,
                             int index,
                             int initialSum,
                             int remainder,
                             int k,
                             Set<Integer> processed,
                             Set<Integer> processing) {

        if (k == 0) return true;
        if (remainder < 0) return false;
        if (remainder == 0) {

            HashSet<Integer> potentialPartitionCopy = new HashSet<>(processing);
            processed.addAll(potentialPartitionCopy);

            boolean found = traverse(nums, 0, initialSum, initialSum, k - 1, processed, new HashSet<>());
            if (found) return true;
            else {
                processed.removeAll(potentialPartitionCopy);
                return false;
            }
        }

        boolean found = false;
        for (int i = index; i < nums.length; i++) {
            if (!processed.contains(i)) {
                processing.add(i);
                found = found | traverse(nums, i + 1, initialSum, remainder - nums[i], k, processed, processing);
                processing.remove(i);
            }
        }

        return found;
    }
}
