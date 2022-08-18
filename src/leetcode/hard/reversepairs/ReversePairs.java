package leetcode.hard.reversepairs;

import java.util.Arrays;

public class ReversePairs {

    int[] aux;

    public int reversePairs(int[] nums) {
        aux = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums,
                          int left,
                          int right) {

        if (left >= right) return 0;
        int middle = (left + right) >>> 1;

        int leftPairs = mergeSort(nums, left, middle);
        int rightPairs = mergeSort(nums, middle + 1, right);
        return leftPairs + rightPairs + merge(nums, left, middle, right);
    }

    private int merge(int[] nums,
                      int left,
                      int middle,
                      int right) {

        int pairs = 0;
        // copy to auxiliary
        for (int i = left; i <= right; i++) aux[i] = nums[i];
        int l = left;
        int r = middle + 1;

        // Count elements
        while (l < middle + 1) {
            if (r <= right && (long)nums[l] > 2 * (long)nums[r]) {
                r++;
                pairs += (middle + 1 -l);
            } else {
                l++;
            }
        }

        // Merge arrays
        l = left;
        r = middle + 1;
        int current = left;
        while ((l < middle + 1 || r < right + 1) && current < right + 1) {
            if (l == middle + 1)
                nums[current++] = aux[r++];
            else if (r == right + 1)
                nums[current++] = aux[l++];
            else {
                if (aux[l] < aux[r])
                    nums[current++] = aux[l++];
                else
                    nums[current++] = aux[r++];
            }
        }

        return pairs;
    }

    public int brute(int[] nums) {

        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) pairs++;
            }
        }

        return pairs;
    }
}
