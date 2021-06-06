package leetcode;

import java.util.Arrays;

public class ShuffleTheArray {

    static int[] extraSpace(int[] nums, int n) {
        int[] extra = new int[nums.length];

        int x = 0;
        int y = n;
        for (int i = 0; i < extra.length; i++) {
            int tmp;
            if (i % 2 == 0) {
                tmp = nums[x++];
            } else {
                tmp = nums[y++];
            }
            nums[i] = tmp;
        }

        return nums;
    }

    static int[] noExtraSpace(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] += nums[n + i] * 10000;
        }

        System.out.println("Before rearrangement: " + Arrays.toString(nums));

        for (int i = n - 1; i >= 0; i--) {
            System.out.println("i=" + i);
            System.out.println("nums[" + (2 * i + 1) + "]= " + nums[i] + " / 1000 = " + nums[i] / 10000);
            nums[2 * i + 1] = nums[i] / 10000;
            System.out.println("nums[" + (2 * i) + "] = " + nums[i] + " % 1000 = " + nums[i] % 10000);
            nums[2 * i] = nums[i] % 10000;
            System.out.println(Arrays.toString(nums));
            System.out.println("=======================================================");
        }

        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(noExtraSpace(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}
