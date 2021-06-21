package leetcode.partitioning;

import java.util.Arrays;

/**
 * In Lomuto's scheme we are using the last element as the pivot
 *
 * THIS IS THE RIGHT ALGORITHM FOR LOMUTO'S PARTITIONING - NO OFF BY ONE ERRORS AND SUCH
 */
public class LomutosPartitioning {

    static void partition(int[] nums,
                          int start,
                          int end) {

        int pivot = nums[end]; // select last element as the pivot
        int i = start;
        for (int j = start; j <= end - 1; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
                System.out.println(Arrays.toString(nums));
            }
        }
        swap(nums, i, end);
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
