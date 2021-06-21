package leetcode.quickselect;

import java.util.Arrays;

public class Playground {
    public static void main(String[] args) {
        int[] nums = {10, 4, 5, 8, 6, 11, 26};
        Quickselect quickselect = new Quickselect();
//        quickselect.selectBottomK(nums, 3);
        quickselect.selectTopK(nums, 3);
        //[4, 5, 6, 8, 10, 11, 26]
        System.out.println(Arrays.toString(nums));
    }
}
