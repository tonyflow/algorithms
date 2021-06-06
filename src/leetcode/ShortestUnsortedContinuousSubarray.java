package leetcode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    static int findUnsortedSubarray(int[] nums) {

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int start = -1;
        int end = -1;

        // Find start
        for (int i = 0; i < nums.length && start == -1; i++) {
            if (nums[i] != sorted[i]) start = i;
        }

        // Find end
        for (int i = nums.length - 1; i >= 0 && end == -1; i--) {
            if (nums[i] != sorted[i]) end = i;
        }

        if (start == -1 && end == -1) return 0;

        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3}));
    }

}
