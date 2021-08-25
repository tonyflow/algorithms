package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int max = 0;
        return max;
    }

    public int extraSpace(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < 0) continue;
            set.add(num);
            max = Math.max(max, num);
        }

        for (int i = 1; i < max; i++)
            if (!set.contains(i)) return i;

        return 1;

    }
}
