package leetcode.hard.findmedianfromdatastream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> a;
    PriorityQueue<Integer> b;
    int size = 0;

    public MedianFinder() {
        a = new PriorityQueue<>(Comparator.reverseOrder());
        b = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (this.size % 2 == 0) {
            a.add(num);
            b.offer(a.poll());
        } else {
            b.add(num);
            a.offer(b.poll());
        }
        this.size++;

    }

    public double findMedian() {
        if (size % 2 == 0) {
            return ((double) (a.peek() + b.peek())) / 2;
        } else {
            return b.peek();
        }
    }
}
