package leetcode.easy;

import java.util.Arrays;

public class RangeSumQueryImmutable {

    class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            this.prefixSum = new int[nums.length];
            Arrays.fill(this.prefixSum, 0);
            int total = 0;
            for (int i = 0; i < this.prefixSum.length; i++) {
                total += nums[i];
                prefixSum[i] = total;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return this.prefixSum[right];
            } else {
                return prefixSum[right] - prefixSum[left - 1];
            }
        }
    }
}
