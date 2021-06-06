package leetcode;

import java.util.Arrays;

/**
 * Some other approach that we can use to solve this:
 * - Use hashset
 *      - Add all numbers into hash set
 *      - iterate all numbers from 0 to n and check whether or not they are in the set
 *
 * - Sort
 *      - Sort the array and check the first missing integer
 * - Bit manipulation
 */
public class MissingNumber {

    static int missingNumber(int[] nums) {
        int n = nums.length;
        return (n*(n+1))/2 - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{1,0,2}));
    }
}
