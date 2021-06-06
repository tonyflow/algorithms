package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class FindTheDuplicateNumber {

    /**
     * Floyd's Tortoise and Hare algorithm for Cycle detection
     */
    static int optimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // or fast - in this case it's the same thing
    }

    int solveWithSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }

    static int findDuplicate(int[] nums) {

        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num)) {
                return num;
            }
            unique.add(num);
        }

        return -1;
    }

    static int findDuplicate2(int[] nums) {

        int[] counts = new int[nums.length + 1];
        Arrays.fill(counts, 0);
        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 2) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
