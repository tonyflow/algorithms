package graphs;

import java.util.Arrays;
import java.util.Stack;

public class DFS {

    private int edgeTo[];
    private boolean visited[];
    private int start;

    public DFS(Graph G, int v) {
        this.edgeTo = new int[G.V()];
        this.visited = new boolean[G.V()];
        this.start = v;

        dfs(G, this.start);
    }

    private void dfs(Graph G, int v) {

        visited[v] = true;
        for (Integer w : G.adjacencyList.get(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public void printEdgeTo() {
        System.out.println(Arrays.toString(edgeTo));
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Stack<Integer> pathTo(int v) {
        Stack<Integer> path = new Stack<>();
        if (hasPathTo(v)) {
            for (int x = v; x != start; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(start);
        }
        return path;
    }
}
