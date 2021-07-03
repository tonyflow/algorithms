package leetcode.targetsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TargetSum {



    public int usingTabulation(int[] nums, int target) {
        return 0;
    }

    class MemoPair {
        int index;
        int currentSum;

        public MemoPair(int index, int currentSum) {
            this.index = index;
            this.currentSum = currentSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoPair memoPair = (MemoPair) o;
            return index == memoPair.index && currentSum == memoPair.currentSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, currentSum);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<MemoPair, Integer> memo = new HashMap<>();
        return sum(nums, 0, 0, target, memo);
    }

    private int sum(int[] nums,
                    int index,
                    int sum,
                    int target,
                    Map<MemoPair, Integer> memo) {
        if (sum == target && index == nums.length) return 1;
        else if (index == nums.length) return 0;
        else {
            MemoPair mElement = new MemoPair(index, sum);
            if (!memo.containsKey(mElement)) {
                int negative = sum(nums, index + 1, sum + (-1) * nums[index], target, memo);
                int positive = sum(nums, index + 1, sum + nums[index], target, memo);
//                System.out.println("Negative sum for index " + index + " is " + negative);
//                System.out.println("Positive sum for index " + index + " is " + positive);
                memo.put(mElement, negative + positive);
            }
            return memo.get(mElement);
        }
    }
}
