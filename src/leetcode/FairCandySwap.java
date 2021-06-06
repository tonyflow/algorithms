package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FairCandySwap {

    static int[] linear(int[] A, int[] B) {

        Map<Integer, Integer> bset = new HashMap<>();

        // Find sum A and B
        int sumOfA = (int) Arrays.stream(A).asDoubleStream().sum();
        int sumOfB = (int) Arrays.stream(B).asDoubleStream().sum();

        for (int b : B) {
            bset.put((sumOfA - sumOfB) / 2 + b, b);
        }

        for (int a : A) {
            if (bset.containsKey(a)) {
                return new int[]{a, bset.get(a)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        linear(new int[]{1, 2, 5}, new int[]{2, 4});
    }

    public int[] fairCandySwap(int[] A, int[] B) {

        // Find sum A
        int sumOfA = (int) Arrays.stream(A).asDoubleStream().sum();
        int sumOfB = (int) Arrays.stream(B).asDoubleStream().sum();

        int[] result = new int[2];
        for (int a : A) {
            for (int b : B) {
                if (sumOfA - a + b == sumOfB - b + a) {
                    return new int[]{a, b};
                }
            }
        }
        return null;
    }
}
