package leetcode;

import java.util.*;

public class HandOfStraights {

    // [1,2,3,6,2,3,4,7,8]
    // [1, 2, 2, 3, 3, 4, 6, 7, 8]

    /**
     * Elements in a set of W elements should be unique
     */
    static boolean group(int[] hand, int W) {

        if (hand.length % W != 0) return false;

        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, Integer> keysToCounts = new TreeMap<>();
        Arrays.sort(hand);

        // Get frequency of hands
        for (int h : hand) {
            if (keysToCounts.containsKey(h)) {
                keysToCounts.put(h, keysToCounts.get(h) + 1);
            } else {
                keysToCounts.put(h, 1);
            }
        }


        while (!keysToCounts.isEmpty()) {

            Integer firstKey = keysToCounts.firstKey();
            for (int i = firstKey; i < firstKey + W; i++) {
                if (!keysToCounts.containsKey(i)) return false;
                Integer count = keysToCounts.get(i);
                if (count - 1 == 0) keysToCounts.remove(i);
                else keysToCounts.replace(i, count - 1);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(group(test, 3));
    }
}
