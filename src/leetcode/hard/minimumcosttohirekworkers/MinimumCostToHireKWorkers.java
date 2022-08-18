package leetcode.hard.minimumcosttohirekworkers;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=o8emK4ehhq0
 */
public class MinimumCostToHireKWorkers {

    public double optimal(int[] quality,
                          int[] wage,
                          int k) {
        double[][] workers = new double[wage.length][2];
        for (int i = 0; i < wage.length; i++) {
            workers[i][0] = (double) wage[i] / (double) quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        double result = Double.MAX_VALUE;

        // Initialize PQ with the k first qualities of the workers array
        PriorityQueue<Double> pq = new PriorityQueue(Comparator.reverseOrder());
        double heapSum = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(workers[i][1]);
            heapSum += workers[i][1];
        }

        result = heapSum * workers[k - 1][0];

        for (int captain = k; captain < workers.length; captain++) {

            if (!pq.isEmpty() && pq.peek() > workers[captain][1]) {
                Double polled = pq.poll();
                heapSum-=polled;
                pq.offer(workers[captain][1]);
                heapSum+=workers[captain][1];
            }

            result = Math.min(result,heapSum*workers[captain][0]);
        }

        return result;
    }

    /**
     * We are sorting by the ratio w/q in increasing order so the available candidates for
     * captain i will always be workers 0 to i-1
     * In order to guarantee that we have at least k workers in the paid group we start with captain i = k-1
     */
    public double better(int[] quality,
                         int[] wage,
                         int k) {

        double[][] workers = new double[wage.length][2];
        for (int i = 0; i < wage.length; i++) {
            workers[i][0] = (double) wage[i] / (double) quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        double result = Double.MAX_VALUE;

        for (int captain = k - 1; captain < quality.length; captain++) {

            double ratio = workers[captain][0];
            List<Double> acceptedOffers = new ArrayList<>();

            for (int j = 0; j < captain + 1; j++) {
                double offer = ratio * workers[j][1];

                // We do not need this check since we are iterating from 0 to captain and the captain ratio will
                // produce wages at least equal to the minimum wages of the first 0 to captain workers
//                if (offer >= wage[j])
                acceptedOffers.add(offer);
            }

            // We will have at least k workers in the paid group
//            if (acceptedOffers.size() < k) continue;

            PriorityQueue<Double> pq = new PriorityQueue(Comparator.reverseOrder());
            double sum = 0;
            for (int j = 0; j < k; j++) {
                pq.offer(acceptedOffers.get(j));
                sum += acceptedOffers.get(j);
            }

            // for the rest
            for (int j = k; j < acceptedOffers.size(); j++) {
                if (acceptedOffers.get(j) < pq.peek()) {
                    Double polled = pq.poll();
                    sum -= polled;
                    pq.offer(acceptedOffers.get(j));
                    sum += acceptedOffers.get(j);
                }
            }

            System.out.println(sum);
            // Update min
            result = Math.min(result, sum);

        }
        return result;
    }

    public double mincostToHireWorkers(int[] quality,
                                       int[] wage,
                                       int k) {

        double result = Double.MAX_VALUE;

        for (int i = 0; i < quality.length; i++) {

            double ratio = (double) wage[i] / (double) quality[i];
            List<Double> acceptedOffers = new ArrayList<>();

            for (int j = 0; j < quality.length; j++) {
                double offer = ratio * quality[j];
                if (offer >= wage[j]) acceptedOffers.add(offer);
            }

            if (acceptedOffers.size() < k) continue;

            PriorityQueue<Double> pq = new PriorityQueue(Comparator.reverseOrder());
            double sum = 0;
            for (int j = 0; j < k; j++) {
                pq.offer(acceptedOffers.get(j));
                sum += acceptedOffers.get(j);
            }

            // for the rest
            for (int j = k; j < acceptedOffers.size(); j++) {
                if (acceptedOffers.get(j) < pq.peek()) {
                    Double polled = pq.poll();
                    sum -= polled;
                    pq.offer(acceptedOffers.get(j));
                    sum += acceptedOffers.get(j);
                }
            }

            System.out.println(sum);
            // Update min
            result = Math.min(result, sum);

        }
        return result;
    }


    /**
     * The following is the brute force approach to the problem. It passes 17 out of 46 cases
     */
    public double bruteForce(int[] quality,
                             int[] wage,
                             int k) {

        return findMin(quality, wage, k, new HashMap<>());
    }

    private double findMin(int[] quality,
                           int[] wage,
                           int k,
                           Map<Integer, Double> selectedWorkerToWage) {
        if (selectedWorkerToWage.size() == k) {
            double total = 0;
            for (Double pay : selectedWorkerToWage.values()) total += pay;
            return total;
        }

        double min = Double.MAX_VALUE;
        for (int i = 0; i < quality.length; i++) {
            if (!selectedWorkerToWage.containsKey(i)) {
                Double minimumPossibleWageForSelectedWorker = findMinimumPossibleWageForSelected(quality, wage, selectedWorkerToWage, i);
                if (minimumPossibleWageForSelectedWorker != null) {
                    selectedWorkerToWage.put(i, minimumPossibleWageForSelectedWorker);
                    double iterationMin = findMin(quality, wage, k, selectedWorkerToWage);
                    selectedWorkerToWage.remove(i);

                    // Update min
                    min = Math.min(min, iterationMin);
                }
            }
        }

        return min;
    }

    private Double findMinimumPossibleWageForSelected(int[] quality,
                                                      int[] wage,
                                                      Map<Integer, Double> selectedWorkerToWage,
                                                      int selected) {
        double min = wage[selected];
        if (!selectedWorkerToWage.isEmpty()) {
            Integer referenceWorker = (Integer) selectedWorkerToWage.keySet().toArray()[0];
            Double referenceWage = (Double) selectedWorkerToWage.values().toArray()[0];
            Double ratio = referenceWage / quality[referenceWorker];
            Double newWage = ratio * quality[selected];
            if (newWage < wage[selected]) return null;
            min = Math.max(min, newWage);
        }
        return min;
    }
}
