package leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int middle = start + end >>> 1;
            if (nums[middle] > nums[middle + 1]) end = middle;
            else start = middle + 1;
        }

        return start;
    }
}
