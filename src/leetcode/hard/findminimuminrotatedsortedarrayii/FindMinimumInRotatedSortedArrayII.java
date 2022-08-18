package leetcode.hard.findminimuminrotatedsortedarrayii;

import java.util.*;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + right >>> 1;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                right--;
            }
        }

        return nums[left];
    }

    public int findMinWithDeduplication(int[] nums) {
        // Deduplicate
        // 0,1,1,1,1,2,
        // 2,6,7,8,8,8,0,1,1,1,1,2
        // 2,6,7,8,0,1
        List<Integer> tmp = new ArrayList();
        Set<Integer> unique = new HashSet();
        for (int i = 0; i < nums.length; ) {
            int reference = nums[i];
            if (!unique.contains(reference)) {
                tmp.add(reference);
                unique.add(reference);
            }
            int k = i + 1;
            while (k < nums.length && nums[k] == reference) k++;
            i = k;
        }

        // Apply BS on tmp
        int left = 0;
        int right = tmp.size() - 1;

        while (left < right) {
            int middle = left + right >>> 1;
            if (tmp.get(right) < tmp.get(middle))
                left = middle + 1;
            else
                right = middle;
        }

        return tmp.get(right);
    }

}
