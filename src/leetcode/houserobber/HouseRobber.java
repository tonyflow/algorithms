package leetcode.houserobber;

import java.util.Arrays;

/**
 * Quite proud for solving this by myself :)
 */
public class HouseRobber {

    int rob(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        for (int i = 0; i < nums.length; i++) {
            visited[i] = true;
            max = Math.max(max, nums[i] + tryRobbingStartingFrom(nums, visited, memo, i));

            // Reset visited for next iteration
            visited[i] = false;
        }

        return max;
    }

    private boolean haveRobbedThisOrAdjacent(Integer house, boolean[] visited) {
        if (visited[house]) return true;

        if (house == 0) {
            return visited[house + 1];
        } else if (house == visited.length - 1) {
            return visited[house - 1];
        } else {
            return visited[house + 1] || visited[house - 1];
        }

    }



    private int tryRobbingStartingFrom(int[] nums,
                                       boolean[] visited,
                                       int[] memo,
                                       int start) {

        int max = 0;
        if (memo[start] == -1) {
            for (int i = start + 2; i < nums.length; i++) {
                if (!haveRobbedThisOrAdjacent(i, visited)) {
                    visited[i] = true;
                    max = Math.max(nums[i] + tryRobbingStartingFrom(nums, visited, memo, i), max);
                    visited[i] = false;
                }
            }

            for (int i = start - 2; i >= 0; i--) {
                if (!haveRobbedThisOrAdjacent(i, visited)) {
                    visited[i] = true;
                    max = Math.max(nums[i] + tryRobbingStartingFrom(nums, visited, memo, i), max);
                    visited[i] = false;
                }
            }
            memo[start] = max;

        }
        return memo[start];
    }
}
