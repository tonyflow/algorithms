package leetcode;

import java.util.*;

public class CheapestFlightsWithinKStops {

    class Pair {
        int id;
        int cost;

        public Pair(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        int getCost() {
            return this.cost;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "id=" + id +
                    ", cost=" + cost +
                    '}';
        }
    }

    class City {
        int id;
        int distanceFromSource;
        int costFromSource;

        public City(int id, int distanceFromSource, int costFromSource) {
            this.id = id;
            this.distanceFromSource = distanceFromSource;
            this.costFromSource = costFromSource;
        }

        int getCostFromSource() {
            return this.costFromSource;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", distanceFromSource=" + distanceFromSource +
                    ", costFromSource=" + costFromSource +
                    '}';
        }
    }

    private Map<Integer, List<Pair>> buildGraph(int[][] flights) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (graph.containsKey(flight[0])) {
                List<Pair> adjacent = graph.get(flight[0]);
                adjacent.add(new Pair(flight[1], flight[2]));
                graph.put(flight[0], adjacent);
            } else {
                List<Pair> adjacent = new ArrayList<>();
                adjacent.add(new Pair(flight[1], flight[2]));
                graph.put(flight[0], adjacent);
            }
        }

        for (Map.Entry<Integer, List<Pair>> e : graph.entrySet()) {
            System.out.println(e.getKey() + " , " + e.getValue());
        }

        return graph;
    }

    public int findCheapestPrice(int n,
                                 int[][] flights,
                                 int src,
                                 int dst,
                                 int k) {

        Map<Integer, List<Pair>> graph = buildGraph(flights);

        if (!graph.containsKey(src)) return -1;
        if ((k == 1 && !graph.get(src).contains(dst))) return -1;

        Queue<City> q = new PriorityQueue<>(Comparator.comparing(City::getCostFromSource).reversed());

        q.add(new City(src, 0, 0));

        while (!q.isEmpty()) {

            System.out.println("Queue state" + q);

            City polled = q.poll();

            if (polled.distanceFromSource > k) continue;

            if (polled.id == dst)
                return polled.costFromSource;

            List<Pair> neighbors = graph.get(polled.id);
            if (neighbors != null) {
                for (Pair neighbor : neighbors) {
                    q.offer(new City(neighbor.id, polled.distanceFromSource + 1, polled.costFromSource + neighbor.cost));
                }
            }

        }

        return -1;

    }
}
