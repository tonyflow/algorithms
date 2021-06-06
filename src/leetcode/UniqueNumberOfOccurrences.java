package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {

    static boolean unique(int[] nums) {

        // 1,2,2,1,1,3
        // [0,3,2,1,0...]
        int[] counts = new int[2002];
        Arrays.fill(counts, 0);

        for (int num : nums) {
            counts[num + 1000]++;
        }

        // Set of unique counts
        HashSet<Integer> countOfCounts = new HashSet<>();
        for (int count : counts) {
            if (count != 0 && countOfCounts.contains(count)) return false;
            countOfCounts.add(count);
        }

        return true;
    }

    static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> counts = new HashSet<>(map.values());
        return counts.size() == map.size();
    }

    public static void main(String[] args) {
//        System.out.println(unique(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
    }
}
