package leetcode;

import java.util.Arrays;

public class MoveZeroes {

    static void moveZeroes(int[] nums) {

        int[] accumulativeZeroesCount = new int[nums.length];
        Arrays.fill(accumulativeZeroesCount, 0);

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                accumulativeZeroesCount[i] = ++runningSum;
            } else {
                accumulativeZeroesCount[i] = runningSum;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i - accumulativeZeroesCount[i]] = nums[i];
            }
        }

        // Backfill zeros
        for (int i = nums.length - 1; i >= nums.length - accumulativeZeroesCount[nums.length - 1]; i--) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        int[] ints2 = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
