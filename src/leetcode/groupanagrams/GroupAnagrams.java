package leetcode.groupanagrams;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<Map<Character, Integer>, List<String>> keeper = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> counts = getCounts(str);
            if (keeper.containsKey(counts)) {
                List<String> update = keeper.get(counts);
                update.add(str);
                keeper.put(counts, update);
            } else {
                ArrayList<String> update = new ArrayList<>();
                update.add(str);
                keeper.put(counts, update);
            }
        }

        return keeper.values().stream().collect(Collectors.toList());
    }

    private Map<Character, Integer> getCounts(String str) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }
}
