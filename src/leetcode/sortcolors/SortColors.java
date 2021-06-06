package leetcode.sortcolors;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        Arrays.fill(counts, 0);
        for (int num : nums) {
            counts[num]++;
        }

        int current = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[current] = i;
                counts[i]--;
                current++;
            }
        }
    }

    int[] aux;

    public void sortColorsMerge(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums,
                      int start,
                      int end) {
        if (start < end) {
            int middle = (start + end) >>> 1;
            sort(nums, start, middle);
            sort(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    private void merge(int[] nums,
                       int start,
                       int middle,
                       int end) {

        // Copy everything to auxiliary
        for (int i = start; i <= end; i++) {
            aux[i] = nums[i];
        }

        int i = start;
        int j = middle + 1;
        int current = start;
        while (i <= middle || j <= end) {
            if (i > middle) nums[current] = aux[j++];
            else if (j > end) nums[current] = aux[i++];
            else {
                if (aux[i] > aux[j]) {
                    nums[current] = aux[j++];
                } else {
                    nums[current] = aux[i++];
                }
            }
            current++;
        }
    }
}
