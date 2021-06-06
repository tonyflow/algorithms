package leetcode;

/**
 * Do not use division!
 */
public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // products from left to right
        int[] leftToRight = new int[nums.length];
        int runningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            runningProduct *= nums[i];
            leftToRight[i] = runningProduct;
        }

        // Reset running product
        runningProduct = 1;

        int[] rightToLeft = new int[nums.length];
        // products from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            runningProduct *= nums[i];
            rightToLeft[i] = runningProduct;
        }

        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = rightToLeft[1];
            } else if (i == result.length - 1) {
                result[i] = leftToRight[nums.length - 2];
            } else {
                result[i] = leftToRight[i - 1] * rightToLeft[i + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
}
