package leetcode.subarrays;

import java.util.HashMap;

public class MakeSumDivisibleByP {

    /**
     * https://leetcode.com/problems/make-sum-divisible-by-p/
     * https://leetcode.com/problems/make-sum-divisible-by-p/discuss/854166/JavaPython-3-O(n)-code-w-brief-explanation-analysis-and-similar-problems./707028
     */
    static int makeSumDivisible(int[] nums, int p) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);

        int totalRemainder = 0;
        int runningRemainder = 0;
        int length = Integer.MAX_VALUE;

        for (int num : nums) {
            totalRemainder = (totalRemainder + num) % p;
        }

        if (totalRemainder == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            runningRemainder = (runningRemainder + nums[i]) % p;
            int wantedRemainder = (runningRemainder - totalRemainder + p) % p;
            if (sums.containsKey(wantedRemainder)) {
                length = Math.min(length, i - sums.get(wantedRemainder));
            }
            sums.put(runningRemainder , i);
        }

        return length == nums.length ? -1 : length;
    }

    public static void main(String[] args) {
        System.out.println(makeSumDivisible(new int[]{3, 1, 4, 2}, 6));
        System.out.println(makeSumDivisible(new int[]{6, 3, 5, 2}, 9));
        System.out.println(makeSumDivisible(new int[]{1, 2, 3}, 3));
        System.out.println(makeSumDivisible(new int[]{1, 2, 3}, 7));
        System.out.println(makeSumDivisible(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }
}
