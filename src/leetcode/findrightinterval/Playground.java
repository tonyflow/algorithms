package leetcode.findrightinterval;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[][] intervals2 = {{1, 4}, {2, 3}, {3, 4}};
        int[][] intervals3 = {{1, 1}, {3, 4}};
        System.out.println(Arrays.toString(findRightInterval.findRightInterval(intervals3)));
    }
}
