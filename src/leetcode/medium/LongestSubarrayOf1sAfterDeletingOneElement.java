package leetcode.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    static public int longestSubarray(int[] nums) {

        int left = 0;
        int right = 0;
        int deleted = 0;
        int helper = 0; // length of the sliding window
        int result = 0;

        // 0, 1, 1, 1, 0, 1, 1, 0, 1
        while (right < nums.length) {
            // keep expanding from the right till we have to delete 2 characters to proceed
            if (nums[right] == 0) deleted++;
            else result = Math.max(result, ++helper);
            if (deleted == 2) {
                // Start retracting the window from the left till we have ONE zero and we can
                // start expanding from the right side again
                while (left <= right && deleted > 1) {
                    if (nums[left] == 0) deleted--;
                    else helper--;
                    left++;
                }
            }
            right++;
        }
        return deleted == 0 ? result - 1 : result;
    }

    static public int brute(int[] nums) {

        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int iterationMax = 0;
            int deleted = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) deleted++;
                // Update maximum only if current element is 1
                // Otherwise we are visiting a 0 which is eligible for deletion
                // so we do not increase maximum
                if (deleted < 2 && nums[j] == 1) iterationMax++;

                if (deleted > 1) break;
            }
            // We MUST delete one character
            if (deleted == 0) iterationMax--;
            globalMax = Math.max(globalMax, iterationMax);
        }

        return globalMax;

    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1};
        int[] b = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] c = {1, 1, 1};
        int[] d = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int[] e = {0, 0, 0};
//        System.out.println(brute(a));
//        System.out.println(brute(b));
//        System.out.println(brute(c));
//        System.out.println(brute(d));
//        System.out.println(brute(e));
        System.out.println(longestSubarray(a));
        System.out.println(longestSubarray(b));
        System.out.println(longestSubarray(c));
        System.out.println(longestSubarray(d));
        System.out.println(longestSubarray(e));
    }
}
