package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {

        if (k > cardPoints.length) return 0;

        // Find prefix sums
        int[] prefix = new int[cardPoints.length];
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++)
            prefix[i] = sum + cardPoints[i];

        int total = prefix[prefix.length - 1];
        int max = prefix[k - 1]; // arbitrarily chose the sum of the first 3 as the max

        int start = k - 1;
        int end = cardPoints.length;
        while (start > -2) {
            if (start < 0) {
                if (end > 0) {
                    max = Math.max(max, total - prefix[end - 1]);
                } else {
                    max = Math.max(max, total);
                }

            } else {
                max = Math.max(max, prefix[start] + (total - prefix[end - 1]));
            }
            start--;
            end--;
        }

        return max;

    }

    public int maxScore2(int[] cardPoints, int k) {
        return doFind(cardPoints, 0, cardPoints.length - 1, k, new HashMap<>());
    }

    int doFind(int[] nums, int start, int end, int k, Map<String, Integer> memo) {
        if (start > end || k == 0) return 0;

        String key = start + " " + end;
        if (!memo.containsKey(key)) {
            int takeTheStart = nums[start] + doFind(nums, start + 1, end, k - 1, memo);
            int takeTheEnd = nums[end] + doFind(nums, start, end - 1, k - 1, memo);
            memo.put(key, Math.max(takeTheStart, takeTheEnd));
        }

        return memo.get(key);
    }

}
