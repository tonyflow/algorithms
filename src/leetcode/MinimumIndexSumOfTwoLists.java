package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {
    static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> restaurantToIndex = new HashMap<>();
        Integer min = Integer.MAX_VALUE;
        String result = "";
        HashSet<String> restaurantSet2 = new HashSet<>(Arrays.asList(list2));
        for (int i = 0; i < list1.length; i++) {
            if (restaurantSet2.contains(list1[i])) {
                restaurantToIndex.put(list1[i], i);
            }
        }

        for (int i = 0; i < list2.length; i++) {
            if (restaurantToIndex.containsKey(list2[i])) {
                restaurantToIndex.put(list2[i], restaurantToIndex.get(list2[i]) + i);
            }
        }

        // Find min
        for (Map.Entry<String, Integer> entry : restaurantToIndex.entrySet()) {
            Integer sum = entry.getValue();
            String restaurant = entry.getKey();
            if (sum < min) {
                min = sum;
                result = restaurant;
            }
        }

        // Finalize min for stream processing
        final int helper = min;

        List<String> tieResults = restaurantToIndex.entrySet().stream()
                .filter(entry -> entry.getValue() == helper).map(e -> e.getKey())
                .collect(Collectors.toList());

        boolean tie = tieResults.size() > 1;
        if (tie) {
            return tieResults.toArray(new String[tieResults.size()]);
        } else {
            return new String[]{result};
        }
    }

    public static void main(String[] args) {

        String[] test1 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] test2 = {"KNN", "KFC", "Burger King", "Tapioca Express", "Shogun"};
        String[] test0 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        System.out.println(Arrays.toString(findRestaurant(test0, test1)));
    }

}
