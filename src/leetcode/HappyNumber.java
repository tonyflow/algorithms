package leetcode;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {

        int sum = n;
        HashSet<Integer> visitedSums = new HashSet<>();
        while (sum != 1) {
            int tmp = sum;
            sum = 0;
            while (tmp > 0) {
                sum += Math.pow(tmp % 10, 2);
                tmp /= 10;
            }

            if (visitedSums.contains(sum)) return false;
            else visitedSums.add(sum);
        }

        return true;
    }
}
