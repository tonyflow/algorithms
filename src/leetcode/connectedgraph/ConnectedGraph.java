package leetcode.connectedgraph;

import java.util.*;

public class ConnectedGraph {

    boolean isConnected(int[][] edges) {
        Map<Integer, List<Integer>> graph = build(edges);
        int V = V(graph);
        for (Integer node : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            dfs(graph, node, visited);
            if (visited.size() != V) return false;
        }

        return true;
    }

    private void dfs(Map<Integer, List<Integer>> graph,
                     int node,
                     Set<Integer> visited) {

        visited.add(node);

        List<Integer> adjacent = graph.get(node);
        if (adjacent != null && !adjacent.isEmpty()) {
            for (Integer v : adjacent) {
                if (!visited.contains(v)) {
                    dfs(graph, v, visited);
                }
            }
        }
    }

    private int V(Map<Integer, List<Integer>> graph) {
        Set<Integer> nodes = new HashSet<>();
        nodes.addAll(graph.keySet());
        for (List<Integer> values : graph.values()) {
            nodes.addAll(values);
        }

        return nodes.size();
    }

    private Map<Integer, List<Integer>> build(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (graph.containsKey(edge[0])) {
                List<Integer> adjacency = graph.get(edge[0]);
                adjacency.add(edge[1]);
            } else {
                List<Integer> adjacency = new ArrayList<>();
                adjacency.add(edge[1]);
                graph.put(edge[0], adjacency);
            }
        }
        return graph;
    }
}
