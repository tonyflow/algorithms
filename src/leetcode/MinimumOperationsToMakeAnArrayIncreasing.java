package leetcode;

public class MinimumOperationsToMakeAnArrayIncreasing {

    public int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int operations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                operations += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }
        return operations;
    }
}
