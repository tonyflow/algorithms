package leetcode;

import java.util.Arrays;

public class ArrayPartitionI {

    static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int a = 0;
        int b = 1;
        while (b < nums.length) {
            sum += Math.min(nums[a], nums[b]);
            a = b + 1;
            b = a + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        arrayPairSum(new int[]{1, 4, 2, 3});
    }
}
