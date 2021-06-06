package leetcode;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int nextInsert = 1;
        int currentNum = nums[0];

        int traverse = 0;

        while (traverse < nums.length) {
            if (nums[traverse] != currentNum) {
                // set number at next pointer to number at traverse
                nums[nextInsert] = nums[traverse];
                currentNum = nums[traverse];
                nextInsert++;
            }
            traverse++;
        }

        return nextInsert;
    }
}
