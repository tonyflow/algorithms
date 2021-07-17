package leetcode.foursumii;

import java.util.*;
import java.util.stream.Collectors;

public class FourSumII {

    class Key {
        int i;
        int j;

        public Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return (i == key.i && j == key.j) || (i == key.i && j != key.j) || (i != key.i && j == key.j) || (i == key.j || j == key.i);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public List<List<Integer>> fourSumNSquared(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums.length > 3) {
            Map<Integer, Set<Key>> sumsToIndexes = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    Key indexes = new Key(i, j);
                    if (sumsToIndexes.containsKey(sum)) {
                        sumsToIndexes.get(sum).add(indexes);
                    } else {
                        Set<Key> toadd = new HashSet<>();
                        toadd.add(indexes);
                        sumsToIndexes.put(sum, toadd);
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int diff = target - (nums[i] + nums[j]);
                    if (sumsToIndexes.containsKey(diff)) {
                        for (Key key : sumsToIndexes.get(diff)) {
                            Set<Integer> unique = new HashSet<>();
                            unique.add(key.i);
                            unique.add(key.j);
                            unique.add(i);
                            unique.add(j);
                            if (unique.size() == 4) {
                                List<Integer> partial = new ArrayList<>();
                                partial.add(nums[i]);
                                partial.add(nums[j]);
                                partial.add(nums[key.i]);
                                partial.add(nums[key.j]);
                                result.add(partial);
                            }
                        }
                    }
                }
            }

//            // This is just another alternative
//            for (Map.Entry<Integer, Set<Key>> sumToIndexes : sumsToIndexes.entrySet()) {
//                int diff = target - sumToIndexes.getKey();
//                if (sumsToIndexes.containsKey(diff)) {
//                    Set<Key> secondHalf = sumsToIndexes.get(diff);
//                    for (Key secondHalfKey : secondHalf) {
//                        for (Key firstHalfKey : sumToIndexes.getValue()) {
//                            if (!firstHalfKey.equals(secondHalfKey)) {
//                                List<Integer> partial = new ArrayList<>();
//                                partial.add(nums[secondHalfKey.i]);
//                                partial.add(nums[secondHalfKey.j]);
//                                partial.add(nums[firstHalfKey.i]);
//                                partial.add(nums[firstHalfKey.j]);
//                                Collections.sort(partial);
//                                result.add(partial);
//                            }
//                        }
//                    }
//                }
//            }
        }
        return result.stream().collect(Collectors.toList());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        ArrayList<Integer> partial = new ArrayList<>();
                        partial.add(nums[i]);
                        partial.add(nums[j]);
                        partial.add(nums[start]);
                        partial.add(nums[end]);
                        Collections.sort(partial);
                        result.add(partial);
                        end--;
                        start++;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return result.stream().collect(Collectors.toList());
    }

}
