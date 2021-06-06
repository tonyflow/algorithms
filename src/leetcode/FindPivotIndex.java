package leetcode;

import java.util.Arrays;

public class FindPivotIndex {

    int another(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - (nums[i] + leftSum)) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {

        int[] rightToLeft = new int[nums.length];
        int[] leftToRight = new int[nums.length];
        int runningSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            runningSum += nums[i];
            rightToLeft[i] = runningSum;
        }

        runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            leftToRight[i] = runningSum;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && rightToLeft[1] == 0) return 0;
            else if (i == nums.length - 1 && leftToRight[nums.length - 2] == 0) return nums.length - 1;
            else if (i > 0 && i < nums.length - 1 && leftToRight[i - 1] == rightToLeft[i + 1]) return i;
        }

        return -1;

    }
}
