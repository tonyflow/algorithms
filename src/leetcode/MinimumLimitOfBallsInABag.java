package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLimitOfBallsInABag {

    // https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/discuss/1064497/Unravel-it-Layer-by-Layer
    // Binary search on the answer space
    static int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = 1_000_000_000;
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) >>> 1;
            int neededOperations = getOperations(nums, middle);
            if (neededOperations > maxOperations) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }

        return answer;

    }

    /**
     * How many operation do we have to perform so that all of the array elements to be less or equal to
     */
    private static int getOperations(int[] nums, int penalty) {
        int total = 0;
        for (int num : nums) {
            if (num > penalty) {
                total += (num % penalty == 0 ? num / penalty - 1 : num / penalty);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
        System.out.println(minimumSize(new int[]{9}, 2));
    }


}
