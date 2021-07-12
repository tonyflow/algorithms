package leetcode.numberofprovinces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = buildGraph(isConnected);
        int components = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (graph.containsKey(i) && !visited[i]) {
                dfs(graph, i, visited);
                components++;
            }
        }
        return components;

    }

    private void dfs(Map<Integer,
            List<Integer>> graph,
                     int node,
                     boolean[] visited) {

        visited[node] = true;
        for (Integer v : graph.get(node)) {
            if (!visited[v]) dfs(graph, v, visited);
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    addEdge(graph, i, j);
                    addEdge(graph, j, i);
                }
            }
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
