package leetcode;

import java.util.Arrays;

public class TwoSumII {

    static int[] find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int complement = nums[left] + nums[right];

            if (complement > target) {
                right--;
            } else if (complement < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(TwoSumII.find(new int[]{0, 1, 1, 2, 4, 5, 6, 7, 16, 80}, 9)));
        System.out.println(Arrays.toString(TwoSumII.find(new int[]{0, 0, 0, 0, 4, 5, 60, 70, 160, 800}, 9)));
    }
}
