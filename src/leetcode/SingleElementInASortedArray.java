package leetcode;

public class SingleElementInASortedArray {

    static int singleNonDuplicateOptimal(int[] nums) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (end + start) >>> 1;
            if (middle % 2 == 0) {
                if (middle < nums.length - 1 && nums[middle] == nums[middle + 1]) {
                    start = middle + 1;
                } else if (middle > 0 && nums[middle] == nums[middle - 1]) {
                    end = middle - 1;
                } else {
                    return nums[middle];
                }
            } else {
                if (middle < nums.length - 1 && nums[middle] == nums[middle + 1]) {
                    end = middle - 1;
                } else if (middle > 0 && nums[middle] == nums[middle - 1]) {
                    start = middle + 1;
                } else {
                    return nums[middle];
                }
            }
        }

        return -1;
    }

//    if (middle == nums.length - 1) {
//
//    } else if (middle == 0) {
//
//    } else

    static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        return find(nums, 0, nums.length - 1);
    }

    static private int find(int[] nums, int start, int end) {
        if (start <= end) {
            int middle = (start + end) >>> 1;
            if (middle > 0 && middle < nums.length - 1) {
                if (nums[middle + 1] == nums[middle] || nums[middle - 1] == nums[middle]) {
                    int foundInLeft = find(nums, start, middle - 1);
                    int foundInRight = find(nums, middle + 1, end);
                    return foundInLeft == -1 ? foundInRight : foundInLeft;
                } else {
                    return nums[middle];
                }
            } else if (middle > 0) {
                // middle == nums.length - 1;
                return nums[middle] == nums[middle - 1] ? -1 : nums[middle];
            } else {
                // middle == 0
                return nums[middle] == nums[middle + 1] ? -1 : nums[middle];
            }
        } else return -1;
    }

    public static void main(String[] args) {
//        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
//        System.out.println(singleNonDuplicate(new int[]{1}));

        System.out.println(singleNonDuplicateOptimal(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
