package hackerrank.lonelyinteger;

import java.util.Arrays;
import java.util.List;

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {
        int[] numberCounts = new int[101];
        Arrays.fill(numberCounts, 0);

        for (Integer number : a) {
            numberCounts[number] = numberCounts[number] + 1;
        }

        for (int i = 0; i <= 100; i++) {
            if (numberCounts[i] == 1) {
                return i;
            }

        }
        return -1;
    }
}
