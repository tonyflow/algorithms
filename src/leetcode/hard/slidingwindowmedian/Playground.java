package leetcode.hard.slidingwindowmedian;

import java.util.Arrays;
import java.util.TreeSet;

public class Playground {

    public static void main(String[] args) {
//        TreeSet<Integer> s = new TreeSet();
//        s.add(6);
//        s.add(4);
//        s.add(19);
//        s.add(3);
//        for (int i : s) System.out.println(i);

//        double a = ((double)Integer.MAX_VALUE +(double)1)/2.0;
//        System.out.println(a);
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        //[2147483647,1,2,3,4,5,6,7,2147483647]
        //2
        int[] a = {Integer.MAX_VALUE,1,2,3,4,5,6,7,Integer.MAX_VALUE};
        System.out.println(Arrays.toString(slidingWindowMedian.medianSlidingWindow(a,2)));

    }
}
