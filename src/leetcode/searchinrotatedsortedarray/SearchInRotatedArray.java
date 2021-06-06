package leetcode.searchinrotatedsortedarray;

public class SearchInRotatedArray {

    static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int middle = -1;
        while (low < high) {
            middle = (high - low) / 2 + low;
            if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (target < nums[low]) {
            low = 0;
        }
        high = nums.length - 1;

        while (low <= high) {
            middle = (high - low) / 2 + low;
            if (target > nums[middle]) {
                low = middle + 1;
            } else if (target < nums[middle]) {
                high = middle - 1;
            } else return middle;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}
