package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {-1, 2, 1, -4};
        int[] test2 = {1, 1, -1, -1, 3};
        System.out.println(threeSumClosest(test, 1));
        System.out.println(threeSumClosest(test2, -1));
    }
}
