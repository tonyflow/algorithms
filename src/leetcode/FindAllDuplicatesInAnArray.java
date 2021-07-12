package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    static public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
                System.out.println(Arrays.toString(nums));
            } else result.add(Math.abs(nums[i]));

        }


        return result;
    }

    // Extra space
    static public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] helper = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (helper[nums[i] - 1] == nums[i]) {
                result.add(nums[i]);
            } else {
                helper[nums[i] - 1] = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(test));
    }
}
