package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MergeSortedArray {

    /**
     * Shift
     */
    static void merge3(int[] nums1,
                       int m,
                       int[] nums2,
                       int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // In case there are elements left from the nums1
        while(i>=0){
            nums1[k--] = nums1[i--];
        }

        // In case there are elements left from the nums2
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }

    static void merge2(int[] nums1,
                       int m,
                       int[] nums2,
                       int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    static void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n) {

        TreeMap<Integer, Integer> numbersToCount = new TreeMap<>();
        // Traverse 1
        for (int i = 0; i < m; i++) {
            numbersToCount.put(nums1[i], numbersToCount.getOrDefault(nums1[i], 0) + 1);
        }

        // Traverse 2
        for (int i = 0; i < n; i++) {
            numbersToCount.put(nums2[i], numbersToCount.getOrDefault(nums2[i], 0) + 1);
        }

        int current = 0;
        while (!numbersToCount.isEmpty()) {
            Map.Entry<Integer, Integer> numberToCount = numbersToCount.firstEntry();
            Integer number = numberToCount.getKey();
            Integer count = numberToCount.getValue();
            while (count > 0) {
                nums1[current] = number;
                current++;
                count--;
            }
            numbersToCount.remove(number);
        }

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 0, 0, 0};
        merge(test, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(test));
    }
}
