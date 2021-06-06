package leetcode.numberofgoodpairs;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfGoodPairs {

    static int[] memo = new int[101];

    static {
        Arrays.fill(memo, -1);
    }

    /**
     * Let's say that we have 4 ones and we want to choose 2 (a pair). How many ways are there to make this choice?
     * This is combinations (order does not matter) without repetition(we cannot choose item from the same index
     * in the same pair) problem. The formula for this is n!/(r!(n-r)!) by replacing r=2 => n!/(2(n-2)!) and after replacing
     * n! = n(n-1)(n-2)! => it becomes (n(n-1))/2
      * @param nums
     * @return
     */
    public int betterWithExtraSpace(int[] nums) {
        int totalPairs = 0;
        int[] counts = new int[101];
        Arrays.fill(counts, 0);
        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            if (count > 1) {
                totalPairs += (count * (count - 1)) / 2;
            }
        }

        return totalPairs;
    }


    private int factorial(int n) {
        if (n < 2) return 1;
        else return n * factorial(n - 1);
    }

    public int numIdenticalPairsBrute(int[] nums) {

        int totalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) totalPairs++;
            }
        }

        return totalPairs;
    }
}
