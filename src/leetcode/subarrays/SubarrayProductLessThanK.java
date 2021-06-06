package leetcode.subarrays;

import java.math.BigInteger;
import java.util.*;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    /**
     * Time limit exceeded
     */
    static int brute(int[] nums, int k) {
        int total = 0;
        Set<List<Integer>> helper = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            BigInteger product = new BigInteger("1");
            List<Integer> subarray = new ArrayList<>();
            int counter = 0;
            for (int j = i; j < nums.length; j++) {
                product = product.multiply(BigInteger.valueOf(nums[j]));
                subarray.add(counter, nums[j]);
                counter++;
                if (product.compareTo(BigInteger.valueOf(k)) < 0) {
                    total++;
                    helper.add(subarray);
                    System.out.println("# " + total + ": " + subarray + " with product " + product);
                    System.out.println("==================");
                } else {
//                    System.out.println("Rejected " + subarray + " with product " + product);
                }

                if (product.compareTo(BigInteger.valueOf(k)) > 0) break;
            }
        }

        System.out.println("Helper size " + helper.size());
        return total;
    }

    static int slide(int[] nums, int k) {

        if (k <= 1) return 0;

        int start = 0;
        int end = 0;
        int product = 1;
        int total = 0;

//        for (int i = 0; i < nums.length; i++) {
//            product *= nums[i];
//        }
//
//        if (product < k && product != 0) {
//            // all combinations
//            for (int window = 1; window <= nums.length; window++) {
//                int endOfWindow = window;
//                while (endOfWindow <= nums.length) {
//                    endOfWindow += 1;
//                    total++;
//                }
//            }
//
//            return total;
//        }
//
//        // Reinitialize
//        product = 1;

        while (end < nums.length) {
            product *= nums[end];
            while (product >= k) {
                product /= nums[start];
                start++;
            }
            total += (end - start) + 1;
            end++;
        }
        return total;
    }

    public static void main(String[] args) {
//        System.out.println(slide(new int[]{10, 5, 2, 6}, 100));
        System.out.println(slide(new int[]{1, 1, 1}, 2));
        System.out.println(slide(new int[]{1, 1, 1}, 1));
//        System.out.println(brute(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 100));

    }
}
