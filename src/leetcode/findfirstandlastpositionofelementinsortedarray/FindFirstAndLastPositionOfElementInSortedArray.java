package leetcode.findfirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0) return result;

        // Find first
        while (start < end) {
            int middle = (start + end) >>> 1;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        if (start != nums.length && nums[start] == target) result[0] = start;

        // Find last
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int middle = (start + end + 1) >>> 1;
            if (nums[middle] <= target) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        if (start != nums.length && nums[start] == target) result[1] = start;

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3}, 3)));
    }
}
