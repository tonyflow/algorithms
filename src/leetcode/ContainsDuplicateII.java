package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> keeper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (keeper.containsKey(nums[i])) {
                Integer indexOfExisting = keeper.get(nums[i]);
                if (Math.abs(indexOfExisting - i) <= k) return true;
            }
            keeper.put(nums[i], i);
        }
        return false;
    }
}
