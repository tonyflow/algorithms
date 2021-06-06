package leetcode.nextpermutation;

import java.util.Arrays;

public class NextPermutationRecap {

    static void nextPermutation(int[] nums) {

        //1 6 4 3 2 1
        // 1 2 3 4 3 2 1
        // Find first non increasing number from the end
        int firstNonIncreasing = nums.length - 2;
        while (firstNonIncreasing >= 0 && nums[firstNonIncreasing] > nums[firstNonIncreasing + 1]) firstNonIncreasing--;
        if (firstNonIncreasing >= 0) {
            int toSwap = nums.length - 1;
            while (nums[toSwap] <= nums[firstNonIncreasing]) toSwap--;

            int tmp = nums[firstNonIncreasing];
            nums[firstNonIncreasing] = nums[toSwap];
            nums[toSwap] = tmp;
        }
        Arrays.sort(nums, firstNonIncreasing + 1, nums.length);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 6, 4, 3, 2, 1};
//        int[] nums = {1, 1, 5};
        int[] nums = {3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(nextPermutation(new int[]{1,6,4,3,2,1})));
    }
}
