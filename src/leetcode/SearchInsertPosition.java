package leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (nums[middle] < target) {
                start = middle + 1;
            } else{
                end = middle;
            }
        }
        return end;
    }
}
