package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums.length; i++) {
            // cell to be replaced
            int cellToBeReplaced = (i + k) % nums.length;

            nums[cellToBeReplaced] = copy[i];
        }
    }

    void rotateOptimal(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums,
                 int start,
                 int end) {

        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    static void rotateOneStepAtATime(int[] nums, int k) {

        for (int i = 1; i <= k; i++) {
            int next = nums[0];
            for (int j = 0; j < nums.length; j++) {
                // cell to be replaced
                int cellToBeReplaced = (j + 1) % nums.length;
                int tmp = nums[cellToBeReplaced];
                nums[cellToBeReplaced] = next;
                next = tmp;
            }
        }
    }

    public static void main(String[] args) {
        rotateOneStepAtATime(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
