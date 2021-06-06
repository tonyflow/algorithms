package leetcode;

public class JumpGame {

    static boolean canJump(int[] nums) {

        if (nums.length == 1) return true;

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {
                max = Math.max(max, nums[i] + i);
            }
        }

        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
//        canJump(new int[]{2, 3, 1, 1, 4});
//        canJump(new int[]{3, 2, 1, 0, 4});
        canJump(new int[]{2, 0, 0});
    }
}
