package leetcode;

import java.util.HashMap;

public class MaximumNumberOfBallsInABox {

    static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> boxCounts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = lowLimit; i <= highLimit; i++) {
            int tmp = i;
            int box = 0;
            while (tmp != 0) {
                box += tmp % 10;
                tmp /= 10;
            }

            boxCounts.put(box, boxCounts.getOrDefault(box, 0) + 1);
            max = Math.max(boxCounts.get(box), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countBalls(1,10));
    }
}
