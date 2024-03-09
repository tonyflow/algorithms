package februaryreset.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

    int minLengthOfSubarraysEqualsTarget(int[] r, int target) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int minLeftSubarray = Integer.MAX_VALUE;
        prefixSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < r.length; i++) {
            sum += r[i];
            prefixSum.put(sum, i);
        }

        sum = 0;
        for (int i = 0; i < r.length; i++) {
            sum += r[i];
            if (prefixSum.containsKey(sum - target)) {
                int lengthOfLeftSubArray = i - prefixSum.get(sum - target);
                minLeftSubarray = Math.min(minLeftSubarray, lengthOfLeftSubArray);
            }

            if (prefixSum.containsKey(sum + target)) {
                int lengthOfRightSubArray = prefixSum.get(sum - target) - i;
                result = Math.min(result, lengthOfRightSubArray + minLeftSubarray);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
