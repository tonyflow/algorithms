package leetcode;

import java.util.Arrays;

public class RemoveElement {

    static int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        int matches = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) matches++;
        }

        if (matches == nums.length) return 0;
        if (matches == 0) return nums.length;

        while (start < end) {
            while (nums[end] == val) end--;
            while (nums[start] != val) start++;

            if (start >= end) break;

            // Swap end with start
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
        }

        int deleted = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) deleted++;
        }
        return nums.length - deleted;
    }

    static int yetAnotherSolution(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin] = nums[i];
                begin++;
            }
        }

        return begin;
    }

    public int usingSorting(int[] nums, int val) {
        int deleted = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                deleted++;
            }
        }

        Arrays.sort(nums);
        return nums.length - deleted;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(yetAnotherSolution(new int[]{3, 2, 2, 3}, 3));
    }
}
