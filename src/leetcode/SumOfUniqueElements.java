package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        int[] counts = new int[101];
        Arrays.fill(counts, 0);
        int sum = 0;

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) sum += i;
        }
        return sum;
    }
}
