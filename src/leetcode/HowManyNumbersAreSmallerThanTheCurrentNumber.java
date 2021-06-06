package leetcode;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        Arrays.fill(counts, 0);

        int[] accumulativeSum = new int[101];
        Arrays.fill(accumulativeSum, 0);

        int[] result = new int[nums.length];

        for (int num : nums) {
            counts[num]++;
        }

        int runningSum = 0;
        for (int i = 0; i < counts.length; i++) {
            runningSum += counts[i];
            accumulativeSum[i] = runningSum;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = accumulativeSum[nums[i]] - counts[nums[i]];
        }

        return result;
    }

    static int[] better(int[] nums) {
        int[] counts = new int[101];
        Arrays.fill(counts, 0);

        int[] result = new int[nums.length];

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = counts[nums[i] - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}));
        System.out.println(Arrays.toString(better(new int[]{8, 1, 2, 2, 3})));
    }
}
