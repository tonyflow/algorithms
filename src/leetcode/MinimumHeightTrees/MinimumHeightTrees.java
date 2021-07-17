package leetcode.MinimumHeightTrees;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Base case
        if (n < 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        Map<Integer, Set<Integer>> graph = buildGraph(edges);
        List<Integer> leaves = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> node : graph.entrySet()) {
            if (node.getValue().size() == 1) {
                leaves.add(node.getKey());
            }
        }

        int remaining = n;
        while (remaining > 2) {

            for (Integer leaf : leaves) {
                graph.remove(leaf);
                for (Map.Entry<Integer, Set<Integer>> node : graph.entrySet()) {
                    if (node.getValue().contains(leaf))
                        node.getValue().remove(leaf);
                }
            }

            // Find new leaves
            leaves.clear();
            for (Map.Entry<Integer, Set<Integer>> node : graph.entrySet()) {
                if (node.getValue().size() == 1) {
                    leaves.add(node.getKey());
                }
            }
            remaining = graph.keySet().size();
        }
        return graph.keySet().stream().collect(Collectors.toList());
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = buildGraph(edges);
        // find min for every node
        Map<Integer, Integer> nodesToMinPath = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nodesToMinPath.put(i, dfs(graph, i, visited));
        }

        int min = Integer.MAX_VALUE;
        for (Integer value : nodesToMinPath.values()) {
            min = Math.min(value, min);
        }

        for (Integer node : nodesToMinPath.keySet()) {
            if (nodesToMinPath.get(node) == min)
                result.add(node);
        }
        return result;
    }

    private Integer dfs(Map<Integer, Set<Integer>> graph,
                        int node,
                        boolean[] visited) {
        visited[node] = true;
        Set<Integer> adjacent = graph.get(node);
        int max = Integer.MIN_VALUE;
        if (adjacent != null && !adjacent.isEmpty()) {
            for (Integer v : adjacent) {
                if (!visited[v]) {
                    int minFromCurrentEnd = 1 + dfs(graph, v, visited);
                    max = Math.max(max, minFromCurrentEnd);
                }
            }
        }
        visited[node] = false;
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            addEdge(graph, from, to);
            addEdge(graph, to, from);
        }
        return graph;
    }

    private void addEdge(Map<Integer, Set<Integer>> graph, int from, int to) {
        if (graph.containsKey(from)) {
            graph.get(from).add(to);
        } else {
            Set<Integer> adjacent = new HashSet<>();
            adjacent.add(to);
            graph.put(from, adjacent);
        }
    }
}
