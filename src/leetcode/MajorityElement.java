package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    int hashing(int[] nums) {
        HashMap<Integer, Integer> numToCounts = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int maxNum = -1;
        for (int num : nums) {
            numToCounts.put(num, numToCounts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> numToCount : numToCounts.entrySet()) {
            int number = numToCount.getKey();
            int count = numToCount.getValue();

            if (count > max) {
                max = count;
                maxNum = number;
            }
        }
        return maxNum;
    }

    static int sorting(int[] nums) {
        Arrays.sort(nums);

        int maxNum = nums[0];
        int currentNum = nums[0];
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxNum = nums[i - 1];
                }
                currentNum = nums[i];
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            return nums[nums.length - 1];
        }

        return maxNum;
    }

    static int sorting2(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    static int boyerMoore(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if(count == 0)
                candidate = num;

            count += (num == candidate)?1:-1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(boyerMoore(new int[]{-1, 100, 2, 100, 100, 4, 100}));
    }
}
