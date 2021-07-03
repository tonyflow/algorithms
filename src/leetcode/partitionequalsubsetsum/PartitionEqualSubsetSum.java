package leetcode.partitionequalsubsetsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PartitionEqualSubsetSum {

    // This is a recursion + memoization approach that TLEs on larger inputs

    class MemoElement {
        int index;
        int sum;
        int numberOfElementsInSum;

        public MemoElement(int index, int sum, int numberOfElementsInSum) {
            this.index = index;
            this.sum = sum;
            this.numberOfElementsInSum = numberOfElementsInSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoElement that = (MemoElement) o;
            return index == that.index && sum == that.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, sum);
        }
    }

    public boolean canPartition(int[] nums) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        Map<MemoElement, Boolean> memo = new HashMap<>();

        return partition(nums, 0, total, nums[0], 1, memo);
    }

    private boolean partition(int[] nums,
                              int index,
                              int total,
                              int sum,
                              int numberOfElementsInSum,
                              Map<MemoElement, Boolean> memo) {

        MemoElement memoElement = new MemoElement(index, sum, numberOfElementsInSum);
        if (memo.containsKey(memoElement)) return memo.get(memoElement);
        if (sum > total) return false;
        if (numberOfElementsInSum == nums.length) return false;

        // Sum of elements in both subsets is equal
        if (total - sum == sum) return true;

        boolean canPartition = false;
        for (int i = index + 1; i < nums.length; i++) {
            canPartition = canPartition | partition(nums, i, total, sum + nums[i], numberOfElementsInSum++, memo);
        }
        memo.put(memoElement, canPartition);
        return memo.get(memoElement);
    }
}
