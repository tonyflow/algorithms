package februaryreset.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {

    private Graph graph;
    private Set<Integer> visited = new HashSet<>();

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public boolean search(int target) {
        boolean found = false;
        for (Integer k : this.graph.adjList.keySet()) {
            found = found || dfs(this.graph, k, this.visited, target);
            if (found) break;
        }

        return found;
    }

    private boolean dfs(Graph graph,
                        Integer current,
                        Set<Integer> visited,
                        Integer target) {
        if (!visited.contains(current)) {
            visited.add(current);
            if (current == target) return true;

            Set<Integer> neighbors = graph.adjList.get(current);
            for (Integer k : neighbors)
                return dfs(graph, k, visited, target);
        }
        return false;
    }


}
