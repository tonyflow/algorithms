package leetcode.redundantconnection;

import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = build(edges);
        List<List<Integer>> edgesToBeRemoved = new ArrayList<>();
        Set<Integer> processing = new HashSet<>();
        Set<Integer> processed = new HashSet<>();
        for (int i = 1; i <= edges.length; i++) {
            dfs(graph, processed, processing, i, -1, edgesToBeRemoved);
        }

        return new int[2];
    }

    private void dfs(Map<Integer, List<Integer>> graph,
                     Set<Integer> processed,
                     Set<Integer> processing,
                     int node,
                     int parent,
                     List<List<Integer>> edgesToBeRemoved) {

        processing.add(node);

        List<Integer> adjacent = graph.get(node);
        if (adjacent != null && !adjacent.isEmpty()) {
            for (Integer v : adjacent) {
                if (parent != v) {
                    if (processing.contains(v)) {
                        edgesToBeRemoved.add(Arrays.asList(node,v));
                    } else {
                        dfs(graph, processed, processing, v, node, edgesToBeRemoved);
                    }
                }
            }
        }

        processing.remove(node);
        processed.add(node);

    }

    private Map<Integer, List<Integer>> build(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            addEdge(graph, from, to);
            addEdge(graph, to, from);
        }
        return graph;
    }

    private void addEdge(Map<Integer, List<Integer>> graph, int i, int j) {
        if (graph.containsKey(i)) {
            graph.get(i).add(j);
        } else {
            List<Integer> adjacent = new ArrayList<>();
            adjacent.add(j);
            graph.put(i, adjacent);
        }
    }


}
