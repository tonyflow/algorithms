package leetcode.hard.theskylineproblem;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
//        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
//        int[][] a = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        theSkylineProblem.getSkylineUseOnlyCriticalPoints(a);

        Coordinate b = new Coordinate(2, 5, true);
        Coordinate c = new Coordinate(2, 8, true);
        Coordinate g = new Coordinate(2, 11, true);
        Coordinate[] bc = {b, c, g};
        Arrays.sort(bc);
        System.out.println(Arrays.toString(bc));
        System.out.println(b.compareTo(c));

        Coordinate d = new Coordinate(2, 5, false);
        Coordinate e = new Coordinate(2, 8, false);
        Coordinate h = new Coordinate(2, 11, false);
        Coordinate[] de = {d, e, h};
        Arrays.sort(de);
        System.out.println(Arrays.toString(de));
        System.out.println(d.compareTo(e));
    }
}
