package leetcode.hard.findmedianfromdatastream;

import java.util.TreeSet;

public class Playground {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
//        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

//        TreeSet<Integer> s = new TreeSet<>();
//        s.add(-1);
//        s.add(-2);
//        s.add(-3);
//        s.add(-4);
//        s.add(-5);
//        System.out.println(s);
    }
}
