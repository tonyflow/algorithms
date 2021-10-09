package leetcode.hard.smallerrangecoveringelementsfromklists;

import java.util.*;

public class SmallerRangeCoveringElementsFromKLists {

    // Optimize with priority queue
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(coordinate -> nums.get(coordinate[0]).get(coordinate[1])));
        int start = 0;
        int end = Integer.MAX_VALUE;

        // Add the first elements of every row
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }


        while (q.size() == nums.size()) {
            int[] polled = q.poll();
            if (max - nums.get(polled[0]).get(polled[1]) < end - start) {
                start = nums.get(polled[0]).get(polled[1]);
                end = max;
            }

            if (polled[1] + 1 < nums.get(polled[0]).size()) {
                q.offer(new int[]{polled[0], polled[1] + 1});
                max = Math.max(max, nums.get(polled[0]).get(polled[1] + 1));
            }
        }

        return new int[]{start, end};
    }

    // Naive approach by iterating all elements
    public int[] smallestRange3(List<List<Integer>> nums) {

        int[] indexes = new int[nums.size()];
        Arrays.fill(indexes, 0);

        int globalMinListIndex = 0;
        int globalMaxListIndex = 0;
        int globalMinListElementIndex = 0;
        int globalMaxListElementIndex = 0;
        int globalMinRange = Integer.MAX_VALUE;

        boolean exceededOneOfTheLists = false;
        while (!exceededOneOfTheLists) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIndex = 0;
            int maxIndex = 0;

            for (int i = 0; i < indexes.length; i++) {
                if (nums.get(i).get(indexes[i]) < min) {
                    min = nums.get(i).get(indexes[i]);
                    minIndex = i;
                }

                if (nums.get(i).get(indexes[i]) > max) {
                    max = nums.get(i).get(indexes[i]);
                    maxIndex = i;
                }
            }
            int iterationMinRange = nums.get(maxIndex).get(indexes[maxIndex]) - nums.get(minIndex).get(indexes[minIndex]);
            if (iterationMinRange < globalMinRange) {
                globalMinRange = iterationMinRange;
                globalMinListIndex = minIndex;
                globalMinListElementIndex = indexes[minIndex];
                globalMaxListIndex = maxIndex;
                globalMaxListElementIndex = indexes[maxIndex];
            }

            if (indexes[minIndex] + 1 == nums.get(minIndex).size()) exceededOneOfTheLists = true;
            else indexes[minIndex]++;
        }

        return new int[]{nums.get(globalMinListIndex).get(globalMinListElementIndex), nums.get(globalMaxListIndex).get(globalMaxListElementIndex)};
    }


    //// Better brute force solution

    class Interval implements Comparable {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            Interval other = (Interval) o;
            if (other.b - other.a == this.b - this.a) {
                return this.a - other.a;
            }
            return (this.b - this.a) - (other.b - other.a);
        }
    }

    public int[] smallestRange2(List<List<Integer>> nums) {
        PriorityQueue<Interval> q = new PriorityQueue<>();
        List<Integer> all = new ArrayList();
        for (List<Integer> partial : nums) {
            all.addAll(partial);
        }
        Collections.sort(all);

        for (int i = 0; i < all.size(); i++) {
            for (int j = i; j < all.size(); j++) {
                q.offer(new Interval(all.get(i), all.get(j)));
            }
        }

        while (!q.isEmpty()) {
            Interval polled = q.poll();
            boolean isCandidate = true;
            for (List<Integer> partial : nums) {
                int elementsInRange = 0;
                for (Integer num : partial) {
                    if (num >= polled.a && num <= polled.b) elementsInRange++;
                }
                if (elementsInRange == 0) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate) return new int[]{polled.a, polled.b};
        }
        return new int[]{-1, -1};
    }

    //// Brute force solution

    public int[] brute(List<List<Integer>> nums) {

        List<Integer> all = new ArrayList();
        for (List<Integer> partial : nums) {
            all.addAll(partial);
        }
        Collections.sort(all);
        int minRange = Integer.MAX_VALUE;
        int[] minInterval = new int[]{0, 0};
        for (int i = 0; i < all.size(); i++) {
            for (int j = i + 1; j < all.size(); j++) {
                int[] candidate = new int[]{all.get(i), all.get(j)};
                boolean isCandidate = false;
                for (List<Integer> partial : nums) {
                    int elementsInRange = 0;
                    for (Integer num : partial) {
                        if (num >= candidate[0] && num <= candidate[1]) elementsInRange++;
                    }
                    if (elementsInRange == 0) {
                        isCandidate = false;
                        break;
                    }
                }
                if (isCandidate && all.get(j) - all.get(i) < minRange) {
                    minRange = all.get(j) - all.get(i);
                    minInterval = candidate;
                }
            }
        }
        return minInterval;
    }
}
