package leetcode;

import java.util.Arrays;

public class Sum3Closest {

    static int[] naive(int[] nums, int target) {

        int[] closest = new int[]{-1, -1, -1};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum3 = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum3 - target) < min) {
                        closest = new int[]{nums[i], nums[j], nums[k]};
                        min = sum3;
                    }
                }
            }
        }
        return closest;
    }

    static int optimize1(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                if (right == i) {
                    right--;
                    continue;
                } else if (left == i) {
                    left++;
                    continue;
                } else {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum > target) right--;
                    else left++;

                    if (Math.abs(sum - target) < Math.abs(min - target)) min = sum;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(naive(new int[]{-1, 2, 1, -4}, 1)));
        System.out.println(optimize1(new int[]{-1, 2, 1, -4}, 1));
    }
}
