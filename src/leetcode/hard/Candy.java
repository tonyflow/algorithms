package leetcode.hard;

public class Candy {

    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++)
            candies[i] = 1;

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = 1 + ratings[i - 1];
        }

        for (int i = candies.length - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(1 + candies[i + 1],candies[i]);
        }

        // Compute max
        int total = 0;
        for (int i = 0; i < candies.length; i++) {
            total += candies[i];
        }
        return total;
    }
}
