package februaryreset.graph;

import java.util.*;

public class TopologicalSort {

    private boolean[] visited;

    public TopologicalSort(Graph graph) {
        this.visited = new boolean[graph.adjList.keySet().size()];
    }

    public List<Integer> sort(Graph graph) {
//        Queue<Integer> preOrder = new LinkedList<>();
//        Queue<Integer> postOrder = new LinkedList<>();
        Stack<Integer> sort = new Stack<>();
        for (Map.Entry<Integer, Set<Integer>> e : graph.adjList.entrySet()) {
            if (!this.visited[e.getKey()]) {
                dfs(graph, e.getKey(), this.visited, sort);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!sort.isEmpty())
            result.add(sort.pop());
        return sort;
    }

    private void dfs(Graph graph,
                     Integer current,
                     boolean[] visited,
                     Stack<Integer> sort) {
        visited[current] = true;
        for (Integer n : graph.adjList.get(current)) {
            if (!visited[n]) dfs(graph, n, visited, sort);
        }

        sort.push(current);
    }

    /**
     * This is Kahn's algorithm for detecting cycles
     */
    private boolean isCyclic(Graph graph) {
        // Initialize inDegree
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (Integer k : graph.adjList.keySet()) {
            inDegree.put(k, 0);
        }
        // Find in degree of all vertices
        for (Map.Entry<Integer, Set<Integer>> e : graph.adjList.entrySet()) {
            for (Integer neighbor : e.getValue()) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // Find one of the vertices with zero in-degree so that we can start
        // the scan from there
        Queue<Integer> nodesWithZeroInDegree = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                nodesWithZeroInDegree.add(e.getKey());
            }
        }

        // Keep a stack with the topological sort
        Stack<Integer> sort = new Stack<>();
        while (!nodesWithZeroInDegree.isEmpty()) {
            Integer polled = nodesWithZeroInDegree.poll();
            sort.push(polled);
            Set<Integer> neighbors = graph.adjList.get(polled);
            for (Integer n : neighbors) {
                inDegree.put(n, inDegree.get(n) - 1);
                if (inDegree.get(n) == 0) nodesWithZeroInDegree.add(n);
            }
        }

        return sort.size() != graph.adjList.keySet().size();
    }
}
