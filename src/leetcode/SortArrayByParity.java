package leetcode;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] % 2 != 0 && nums[end] % 2 == 0) {
                //swap
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            } else if (nums[start] % 2 == 0 && nums[end] % 2 != 0) {
                // do nothing - already in place
                start++;
                end--;
            } else if (nums[start] % 2 == 0 && nums[end] % 2 == 0) {
                // both even
                start++;
            } else {
                end--;
                // both odd
            }
        }
        return nums;
    }
}
