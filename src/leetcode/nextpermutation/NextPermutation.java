package leetcode.nextpermutation;

import java.util.Arrays;

public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {

        int startOfAscendingSequence = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            // Decreasing order from the end
            if (nums[i] > nums[i - 1]) {
                int pivotElement = nums[i - 1];

                // Find element greater than pivotElement and closest to it
                int minDiff = Integer.MAX_VALUE;
                int nextGreaterIndex = i;
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > pivotElement) {
                        nextGreaterIndex = j;
                        break;
                    }
                }

                // Swap nextGreaterIndex and i-1
                swap(nums, nextGreaterIndex, i - 1);

                //
                startOfAscendingSequence = i;
                break;
            }
        }

        // Reverse elements from i to n - Since i to n is increasing
        // so when we reverse them the sequence is going to be decreasing
        int start = startOfAscendingSequence;
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }

        return nums;
    }

    private static void swap(int[] numberChars, int i, int j) {
        int tmp = numberChars[i];
        numberChars[i] = numberChars[j];
        numberChars[j] = tmp;
    }

    static int[] leetCodeSolution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i + 1);

        return nums;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{2, 3, 1, 3, 3})));
//        System.out.println(Arrays.toString(leetCodeSolution(new int[]{2, 3, 1, 3, 3})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 3, 2})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1})));
    }
}
