package leetcode.findfirstandlastpositionofelementinsortedarray;

public class Recap {

    public int[] searchRange(int[] nums, int target) {


        int start = 0;
        int end = nums.length - 1;

        int[] result = {-1, -1};

        // Find first
        while (start < end) {
            int middle = (start + end) >>> 1;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        result[0] = start;

        // Find last
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int middle = (start + end + 1) >>> 1;
            if (nums[middle] <= target) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }
        result[1] = start;

        return result;
    }
}
