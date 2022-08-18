package leetcode.hard;

import java.util.*;

public class SumOfDistancesInTree {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> tree = createAdjacencyList(edges);

        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distances, 0);
            Arrays.fill(visited,false);
            dfs(i, tree, visited, distances, 0);
            result[i] = accumulateDistances(distances);
        }

        return result;
    }

    private int accumulateDistances(int[] distances) {
        int total = 0;
        for (int distance : distances)
            total += distance;
        return total;
    }

    private void dfs(int node,
                     Map<Integer, List<Integer>> tree,
                     boolean[] visited,
                     int[] distances,
                     int distance) {

        visited[node] = true;
        distances[node] = distance;
        if (tree.containsKey(node)) {
            for (Integer neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, tree, visited, distances, distance + 1);
                }
            }
        }
    }

    private Map<Integer, List<Integer>> createAdjacencyList(int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap();

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], tree);
            addEdge(edge[1], edge[0], tree);
        }

        return tree;
    }

    private void addEdge(int a, int b, Map<Integer, List<Integer>> tree) {
        List<Integer> update;
        if (tree.containsKey(a)) {
            update = tree.get(a);
        } else {
            update = new ArrayList();
        }
        update.add(b);
        tree.put(a, update);
    }
}
