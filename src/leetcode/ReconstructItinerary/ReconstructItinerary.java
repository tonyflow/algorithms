package leetcode.ReconstructItinerary;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        List<String> path = new ArrayList<>();

        eulerianPath(graph, "JFK", path);
        return path;
    }

    private void eulerianPath(Map<String, PriorityQueue<String>> graph,
                              String node,
                              List<String> path) {
        PriorityQueue<String> adjacent = graph.get(node);
        if (adjacent != null && !adjacent.isEmpty()) {
            while (!adjacent.isEmpty()) {
                // We remove the edge from the graph so that we cannot traverse it again
                String v = adjacent.poll();
                eulerianPath(graph, v, path);
            }
        }

        path.add(0, node);
    }

    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                PriorityQueue<String> destinations = new PriorityQueue<>();
                destinations.add(to);
                graph.put(from, destinations);
            }
        }
        return graph;
    }
}
