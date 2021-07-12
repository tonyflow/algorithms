package leetcode.isgraphbipartite;

import java.util.*;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {

        Map<Integer, List<Integer>> adjacency = build(graph);
        Set<Integer> processed = new HashSet<>();
        boolean[] color = new boolean[graph.length];

        for (Integer node : adjacency.keySet()) {
            if (!check(adjacency, node, processed, color)) return false;
        }
        return true;
    }

    private boolean check(Map<Integer, List<Integer>> adjacency,
                          Integer node,
                          Set<Integer> processed,
                          boolean[] color) {

        processed.add(node);
        for (Integer v : adjacency.get(node)) {
            if (!processed.contains(v)) {
                color[v] = !color[node];
                check(adjacency, v, processed, color);
            } else if (color[node] == color[v]) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> build(int[][] graph) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            List<Integer> adjacent = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                adjacent.add(graph[i][j]);
            }
            adjacency.put(i, adjacent);
        }
        return adjacency;
    }
}
