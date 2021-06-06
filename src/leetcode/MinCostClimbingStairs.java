package leetcode;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(stairsMin(cost, memo, 0), stairsMin(cost, memo, 1));
    }

    private int stairsMin(int[] cost,
                          int[] memo,
                          int step) {
        if (step < cost.length) {
            if (memo[step] == -1) {
                memo[step] = cost[step] + Math.min(stairsMin(cost, memo, step + 1), stairsMin(cost, memo, step + 2));
            }
            return memo[step];

        } else {
            return 0;
        }
    }


}
