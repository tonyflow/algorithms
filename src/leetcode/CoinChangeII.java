package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap<>();
        Arrays.sort(coins);
        return iterate(coins, 0, amount, memo);
    }

    private int iterate(int[] nums,
                        int index,
                        int remainder,
                        Map<String, Integer> memo) {

        if (index == nums.length || remainder < 0) return 0;
        if (remainder == 0) return 1;

        String key = index + "_" + remainder;
        if (!memo.containsKey(key)) {
            int total = 0;
            for (int i = index; i < nums.length; i++) {
                total += iterate(nums, i, remainder - nums[i], memo);
            }
            memo.put(key, total);
        }


        return memo.get(key);
    }

}
