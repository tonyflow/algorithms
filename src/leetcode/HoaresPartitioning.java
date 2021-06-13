package leetcode;

import java.util.Arrays;

public class HoaresPartitioning {

    static void partition(int[] nums) {
        int pivot = nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 2;
        while (start < end) {
            while (nums[start] <= pivot) start++;
            while (nums[end] >= pivot) end--;
            if (start < end) swap(nums, start, end);
        }
        // start == end at this point
        swap(nums, start, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 67, 0, -1, 7, 8, 9, 3};
        partition(nums);
        System.out.println(Arrays.toString(nums));
    }
}
