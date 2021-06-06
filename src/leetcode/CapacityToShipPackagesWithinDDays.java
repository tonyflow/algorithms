package leetcode;

// THIS IS A HARD PROBLEM
public class CapacityToShipPackagesWithinDDays {

    static int shipWithinDays(int[] weights, int D) {
        int sumWeight = 0;
        int maxWeight = Integer.MIN_VALUE;
        // Find sum of weights
        for (int weight : weights) {
            sumWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int minCapacity = Integer.MAX_VALUE;

        int start = maxWeight;
        int end = sumWeight;

        while (start <= end) {
            int middle = (start + end) >>> 1; // (end-start)/2 + start;
            // Can we ship all shipments in D days using this capacity?
            int runningSum = 0;
            int daysNeeded = 1;
            for (int weight : weights) {
                if ((weight + runningSum) <= middle) {
                    runningSum += weight;
                } else {
                    daysNeeded++;
                    runningSum = weight;
                }
            }

            if (daysNeeded <= D) {
                minCapacity = Math.min(minCapacity, middle);
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return minCapacity;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
        ;
    }
}
