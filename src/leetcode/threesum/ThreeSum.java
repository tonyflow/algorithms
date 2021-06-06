package leetcode.threesum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> tle(int[] nums) {
        HashMap<Integer, List<Pair>> diffToIndex = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (diffToIndex.containsKey(sum)) {
                    List<Pair> pairs = diffToIndex.get(sum);
                    pairs.add(new Pair(i, j));
                    diffToIndex.put(sum, pairs);
                } else {
                    ArrayList<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(i, j));
                    diffToIndex.put(sum, pairs);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int complementary = 0 - nums[i];
            if (diffToIndex.containsKey(complementary)) {
                for (Pair pair : diffToIndex.get(complementary)) {
                    if (pair.i != pair.j && pair.i != i && pair.j != i) {
//                        HashSet<Integer> triplet = new HashSet<>();
//                        triplet.add(nums[pair.i]);
//                        triplet.add(nums[pair.j]);
//                        triplet.add(nums[i]);
                        Integer[] triplet = {nums[pair.i], nums[pair.j], nums[i]};
                        Arrays.sort(triplet);
                        result.add(Arrays.asList(triplet));
                    }
                }
            }
        }

        return result.stream().map(s -> new ArrayList<>(s)).collect(Collectors.toList());
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    Integer[] triplet = new Integer[]{nums[i], nums[j], nums[k]};
                    Arrays.sort(triplet);
                    result.add(Arrays.asList(triplet));
                    break;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }


}
