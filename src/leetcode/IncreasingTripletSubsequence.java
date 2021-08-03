package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = -pile - 1;
            if (pile == piles.size()) piles.add(num);
            else piles.set(pile, num);

            if (piles.size() > 2) return true;

        }

        return false;
    }

    // 75/76 test cases passed
    public boolean slow(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                max = Math.max(max, dp[i]);
                if (max >= 3) return true;
            }
        }

        return false;
    }
}
