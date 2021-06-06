package leetcode.oddevenjump;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Odd: r[i] <= r[j], r[j] = min of the array after i
 * Even: r[i] >= r[j], r[j] = max of the array after i
 */
public class OddEvenJumpOptimal {

    int jump(int[] r) {
        int N = r.length;
        boolean[] higherOrOddJumps = new boolean[N];
        boolean[] lowerOrEvenJumps = new boolean[N];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        higherOrOddJumps[N - 1] = true;
        lowerOrEvenJumps[N - 1] = true;
        map.put(r[N - 1], N - 1);

        int goodStartingPoints = 1;

        for (int i = N - 2; i >= 0; i--) {

            System.out.println("i = " + i + ", r[i] = " + r[i]);
            // Least key greater or equal to the given key
            Map.Entry<Integer, Integer> min = map.ceilingEntry(r[i]);

            // Greatest key less or equal to the given key
            Map.Entry<Integer, Integer> max = map.floorEntry(r[i]);

            // Update higher or odd array
            if (min != null) {
                higherOrOddJumps[i] = lowerOrEvenJumps[min.getValue()];
                System.out.println("Least key greater or equal to " + r[i] + " in map is " + min.getKey() + ". Map with keys " + map.keySet().stream().map(num -> Integer.toString(num)).collect(Collectors.joining(", ")));
                System.out.println(Arrays.toString(higherOrOddJumps));
            } else {
                System.out.println("Did not find key greater or equal to " + r[i] + " in map with keys " + map.keySet().stream().map(num -> Integer.toString(num)).collect(Collectors.joining(", ")));
            }

            // Update lower or even array
            if (max != null) {
                lowerOrEvenJumps[i] = higherOrOddJumps[max.getValue()];
                System.out.println("Greatest key less or equal to " + r[i] + " in map is " + max.getKey() + ". Map with keys " + map.keySet().stream().map(num -> Integer.toString(num)).collect(Collectors.joining(", ")));
                System.out.println(Arrays.toString(lowerOrEvenJumps));
            } else {
                System.out.println("Did not find key less or equal to " + r[i] + " in map with keys " + map.keySet().stream().map(num -> Integer.toString(num)).collect(Collectors.joining(", ")));
            }

            if (higherOrOddJumps[i]) goodStartingPoints++;
            map.put(r[i], i);
            System.out.println("=============================================================");

        }

        return goodStartingPoints;
    }
}
