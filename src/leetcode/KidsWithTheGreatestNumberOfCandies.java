package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;

        // Find max candies
        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        // Create boolean array
        List<Boolean> hasMaximumNumberOfCandy = new ArrayList<>();

        // Try to distribute the candies so that other kids can have equal to max candies
        for (int i = 0; i < candies.length; i++) {
            hasMaximumNumberOfCandy.add(candies[i] + extraCandies >= max);
        }

        return hasMaximumNumberOfCandy;
    }
}
