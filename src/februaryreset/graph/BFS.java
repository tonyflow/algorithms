package februaryreset.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BFS {

    private boolean[] visited;
    private Integer[] edgeTo;

    private Integer source;

    private Graph graph;

    public BFS(Graph graph, Integer source) {
        this.graph = graph;
        this.source = source;
        this.visited = new boolean[graph.V()];
        this.edgeTo = new Integer[graph.E()];
    }

    public void search() {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(this.source);
        this.visited[this.source] = true;

        while (!todo.isEmpty()) {
            Integer polled = todo.poll();
            Set<Integer> neighbors = this.graph.adjList.get(polled);
            for (Integer n : neighbors) {
                if (!this.visited[n]) {
                    this.visited[n] = true;
                    edgeTo[n] = polled;
                    todo.add(n);
                }
            }
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
