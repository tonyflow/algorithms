package februaryreset.graph;

import java.util.Stack;

public class DFS2 {

    private boolean[] visited;
    private Integer[] edgeTo;

    private Integer source;

    private Graph graph;

    public DFS2(Graph graph, Integer source) {
        this.graph = graph;
        this.source = source;
        this.visited = new boolean[graph.V()];
        this.edgeTo = new Integer[graph.E()];
    }

    public void search() {
        search(this.source);
    }

    private void search(Integer v) {
        this.visited[v] = true;

        for (Integer w : this.graph.adjList.get(v)) {
            edgeTo[w] = v;
            if (!visited[w]) search(w);
        }
    }

    public boolean hasPath(Integer t) {
        return visited[t];
    }

    public Stack<Integer> pathTo(int t) {
        Stack<Integer> path = new Stack<>();
        for (int x = this.source; x != t; x = edgeTo[t])
            path.push(x);

        return path;
    }
}
