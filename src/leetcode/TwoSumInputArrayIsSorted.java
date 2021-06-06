package leetcode;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted {

    static int[] twoSumTwoPointers(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int runningSum = numbers[start] + numbers[end];
            if (runningSum > target) {
                end--;
            } else if (runningSum < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumTwoPointers(new int[]{-1, 0}, -1)));
    }
}
