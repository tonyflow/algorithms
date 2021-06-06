package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> num1Set = new HashSet<>();
        HashSet<Integer> num2Set = new HashSet<>();

        for (int i : nums1) {
            num1Set.add(i);
        }
        for (int i : nums2) {
            num2Set.add(i);
        }

        num1Set.retainAll(num2Set);
        List<Integer> retention = new ArrayList<>(num1Set);

        int[] result = new int[num1Set.size()];

        for (int i = 0; i < num1Set.size(); i++) {
            result[i] = retention.get(i);
        }

        return result;


    }
}
