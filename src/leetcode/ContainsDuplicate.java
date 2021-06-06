package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> foo = new HashSet<>();
        for (int num : nums) {
            if(foo.contains(num)) return true;
            foo.add(num);
        }
        return false;
    }
}
