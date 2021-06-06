package leetcode;

public class CheckIfArraysIsSortedAndRotated {

    /**
     * Another great solution here: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/discuss/1053508/JavaC++Python-Easy-and-Concise
     */
    public static boolean check(int[] nums) {

        if (nums.length == 1) return true;

        boolean foundArrayStructure = false;
        for (int i = 0; i < nums.length && !foundArrayStructure; i++) {
            // Find pivot
            // Potential pivot points
            if (i == 0 && nums[i] <= nums[i + 1]) {
                foundArrayStructure = checkRotation(i, nums);
            } else if (i == nums.length - 1 && nums[i - 1] > nums[i]) {
                foundArrayStructure = checkRotation(i, nums);
            } else if (i > 0 && i < nums.length - 1 && nums[i - 1] > nums[i] && nums[i] <= nums[i + 1]) {
                foundArrayStructure = checkRotation(i, nums);
            }
        }
        return foundArrayStructure;
    }

    private static boolean checkRotation(int start, int[] nums) {
        for (int j = start; j < nums.length + start - 1; j++) {
            if (nums[j % nums.length] > nums[(j + 1) % nums.length]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(check(new int[]{3,4,5,1,2}));
        System.out.println(check(new int[]{2, 1}));
    }
}
