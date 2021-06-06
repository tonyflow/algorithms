package leetcode;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {

    static int leetCodeSolution(int[] bloomDay, int m, int k) {
        // If the array contains less flowers than we actually need we just
        // return -1
        if (bloomDay.length < k * m) return -1;

        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();

        int start = min;
        int end = max;
        while (start < end) {
            int middle = (start + end) >>> 1;

            // Traverse the bloom array and calculate the number of bouquet we
            // can create in middle days
            int adjacent = 0;
            int bouquets = 0;

            for (int flower : bloomDay) {
                if (flower <= middle) {
                    adjacent++;
                } else {
                    adjacent = 0;
                }

                if (adjacent == k) {
                    bouquets++;
                    adjacent = 0;
                }
            }

            if (bouquets < m) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return start;
    }

    static int minDays(int[] bloomDay, int m, int k) {

        // Find min & max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int[] bloomDaySpace = new int[max - min + 1];
        Arrays.fill(bloomDaySpace, 0);
//        Arrays.sort(bloomDay);

        for (int i = 0; i < bloomDay.length - k + 1; i += k) {
            // Find max
            int groupMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                groupMax = Math.max(groupMax, bloomDay[j]);
            }
            bloomDaySpace[groupMax - min] += k;
        }

        // Create accumulative sum
        for (int i = 1; i < bloomDaySpace.length; i++) {
            bloomDaySpace[i] += bloomDaySpace[i - 1];
        }

        int start = 0;
        int end = bloomDaySpace.length - 1;
        int totalNumberOfFlowersForAllBouquets = m * k;
        if (totalNumberOfFlowersForAllBouquets > bloomDaySpace[bloomDaySpace.length - 1]) {
            return -1;
        } else {
            while (start < end) {
                int middle = (start + end) >>> 1;
                if (bloomDaySpace[middle] >= totalNumberOfFlowersForAllBouquets) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }

            return start + min;
        }
    }

    public static void main(String[] args) {
//        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
//        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
//        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
//        System.out.println(minDays(new int[]{1000000000, 1000000000}, 1, 1));
//        System.out.println(minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
//        System.out.println(minDays(new int[]{5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28}, 8, 2));


        System.out.println(leetCodeSolution(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(leetCodeSolution(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(leetCodeSolution(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(leetCodeSolution(new int[]{1000000000, 1000000000}, 1, 1));
        System.out.println(leetCodeSolution(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
        System.out.println(leetCodeSolution(new int[]{5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28}, 8, 2));
    }
}
