package leetcode.HouseRobberII;

import java.util.*;

public class HouseRobberII {

    int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        Set<Integer> robbed = new HashSet<>();
        return rob(nums, 0, robbed, memo);
    }

    private int rob(int[] nums,
                    int index,
                    Set<Integer> robbed,
                    int[] memo) {
        if (index >= nums.length) return 0;
        if (robbed.contains(index)) return 0;
        if (memo[index] == -1) {
            int robCurrent = 0;
            if (canRob(robbed, nums.length, index)) {
                robbed.add(index);
                robCurrent = nums[index] + rob(nums, index + 2, robbed, memo);
                robbed.remove(index);
            }

            int doNotRobCurrent = rob(nums, index + 1, robbed, memo);
            memo[index] = Math.max(robCurrent, doNotRobCurrent);
        }

        return memo[index];
    }

    class MemoKey {
        int index;
        Set<Integer> robbed;

        public MemoKey(int index, Set<Integer> robbed) {
            this.index = index;
            this.robbed = robbed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoKey memoKey = (MemoKey) o;
            return index == memoKey.index && Objects.equals(robbed, memoKey.robbed);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, robbed);
        }
    }

    public int robInvolved(int[] nums) {
        Set<Integer> stolen = new HashSet<>();
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return doRob(nums, 0, stolen, memo);
    }

    private int doRob(int[] nums,
                      int start,
                      Set<Integer> robbed,
                      int[] memo) {

        if (memo[start] == -1) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                // if it has not been robbed and if it can be robbed then
                if (!robbed.contains(i) && canRob(robbed, nums.length, i)) {
                    // add it to the robbed and recurse
                    robbed.add(i);
                    max = Math.max(max, nums[i] + doRob(nums, i, robbed, memo));
                    System.out.println("max=" + max + " with processed " + robbed);
                    robbed.remove(i);
                }
            }
            memo[start] = max;
        }


        return memo[start];
    }

    private boolean canRob(Set<Integer> robbed,
                           int lengthOfTheCirclesPerimeter,
                           int candidate) {

        int adjacentToTheRight = (candidate + 1) % lengthOfTheCirclesPerimeter;
        int adjacentToTheLeft = candidate - 1 < 0 ? lengthOfTheCirclesPerimeter - 1 : candidate - 1;

        return !robbed.contains(adjacentToTheRight) && !robbed.contains(adjacentToTheLeft);
    }
}
