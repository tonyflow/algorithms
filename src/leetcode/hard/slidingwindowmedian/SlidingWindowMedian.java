package leetcode.hard.slidingwindowmedian;

import java.util.*;

public class SlidingWindowMedian {

    PriorityQueue<Integer> a = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> b = new PriorityQueue();
    int size = 0;
    List<Double> helper = new ArrayList();

    public double[] medianSlidingWindow(int[] nums, int k) {
        // a = 5,4,3,2,1
        // b = 6,7,8,8,9
        // median = (a.peek()+b.peek())/2
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j - i + 1 < k) {
                add(nums[j]);
            } else {
                add(nums[j]);
                helper.add(findMedian());
                remove(nums[i++]);
            }
        }

        double[] result = new double[helper.size()];
        for (int i = 0; i < result.length; i++) result[i] = helper.get(i);

        return result;
    }

    private void add(int num) {
        if (size % 2 == 0) {
            a.offer(num);
            b.offer(a.poll());
        } else {
            b.offer(num);
            a.offer(b.poll());
        }
        if (a.size() > b.size()) {
            b.offer(a.poll());
        }
        size++;
    }

    private void remove(int num) {
        double median = findMedian();
        if (num < median) {
            a.remove(num);
        } else {
            b.remove(num);
        }
        if (b.size() - a.size() > 1) {
            a.offer(b.poll());
        }
        size--;
    }

    private double findMedian() {
        if (size % 2 == 0) {
            return ((double) a.peek() + (double) b.peek()) / 2.0;
        }
        return b.peek();
    }

    //////////////////////////////////////////////////////////

    // 1,3,-1,-3,5,3,6,7 and 3
    public double[] brute(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap();
        double[] result = new double[nums.length - k];
        List<Double> helper = new ArrayList();

        // n*k*log(k)
        for (int i = 0, j = k; k < nums.length; i++, j++) {
            int[] copy = Arrays.copyOfRange(nums, i, j + 1);
            Arrays.sort(copy);
            if (k % 2 == 0) {
                helper.add(((double) copy[k / 2] + (double) copy[k / 2 + 1]) / 2.0);
            } else {
                helper.add((double) copy[k / 2]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = helper.get(i);
        }

        return result;
    }
}
