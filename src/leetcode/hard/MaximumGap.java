package leetcode.hard;

import java.util.Arrays;

public class MaximumGap {

    public int maximumGap(int[] nums) {

        if(nums.length<2) return 0;
        int max = Integer.MIN_VALUE;
        sort(nums);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i - 1]));
        }

        return max;
    }

    void sort(int[] nums) {
        int max = getMax(nums);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(nums, nums.length, exp);
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, nums[i]);

        return max;
    }

    private void countSort(int[] nums, int n, int exp) {

        int[] output = new int[n];
        int[] counts = new int[10];
        Arrays.fill(counts, 0);

        for (int i = 0; i < n; i++) {
            int index = (nums[i] / exp) % 10;
            counts[index]++;
        }

        for (int i = 1; i < 10; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (nums[i] / exp) % 10;
            output[counts[index] - 1] = nums[i];
            // since we have placed this element, there are n-1 elements to place for this digit
            counts[index]--;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = output[i];
        }
    }
}
