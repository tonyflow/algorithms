package leetcode.partitioning;

import java.util.Arrays;

public class HoaresPartitioning {

    static void partition(int[] nums,
                          int start,
                          int end) {
        int i = start;
        int j = end + 1;
        int pivot = nums[start];

        while (true) {
            while (nums[++i] < pivot) if (i == end) break;
            while (nums[--j] > pivot) if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
            System.out.println(Arrays.toString(nums));
        }

        swap(nums, j, start);

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 67, 0, -1, 7, 8, 9, 1};
        partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
