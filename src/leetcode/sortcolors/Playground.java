package leetcode.sortcolors;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] test = {2, 0, 2, 1, 1, 0};
        sortColors.sortColorsMerge(test);
        System.out.println(Arrays.toString(test));
    }
}
