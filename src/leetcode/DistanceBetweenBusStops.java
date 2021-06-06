package leetcode;

public class DistanceBetweenBusStops {

    static int findMinimumDistance(int[] distance,
                                   int start,
                                   int destination) {

        if (start == destination) return 0;
        if(destination == 0) {
            destination = start;
            start = 0;
        }

        int N = distance.length;
        int clockWiseSum = 0;
        int counterClockWiseSum = 0;

        // Find clockwise sum
        for (int i = start; i != destination; i = (i + 1) % N) {
            System.out.println("Clockwise i= " + i);
            clockWiseSum += distance[i];
        }

        // Find counterclockwise sum
        for (int i = (start - 1 + N) % N; i != destination - 1; i = (i - 1 + N) % N) {
//            System.out.println("Counter Clockwise i= " + i);
            counterClockWiseSum += distance[i];
        }

        return Math.min(counterClockWiseSum, clockWiseSum);
    }

    public static void main(String[] args) {
//        System.out.println(findMinimumDistance(new int[]{1, 2, 3, 4}, 0, 1));
//        System.out.println(findMinimumDistance(new int[]{1, 2, 3, 4}, 0, 2));
//        System.out.println(findMinimumDistance(new int[]{1, 2, 3, 4}, 0, 3));
        System.out.println(findMinimumDistance(new int[]{6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1, 44, 41, 14, 5, 38, 25, 48}, 22, 0));
    }
}
