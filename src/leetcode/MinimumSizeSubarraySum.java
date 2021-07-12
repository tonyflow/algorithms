package leetcode;

public class MinimumSizeSubarraySum {

    static public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int right = i;
            int sum = 0;
            while (right < nums.length) {
                sum += nums[right];
                if (sum >= target) {
                    result = Math.min(result, right - i + 1);
                }
                right++;
            }
        }

        return result;
    }

    static public int another(int target, int[] nums) {

        int left = 0;
        int right = 0;

        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;

            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, test));
        System.out.println(another(7, test));
    }

}
