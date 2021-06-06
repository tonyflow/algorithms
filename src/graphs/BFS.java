package graphs;

import java.util.*;

public class BFS {

    private int edgeTo[];
    private boolean visited[];
    private int start;

    public BFS(Graph G, int v) {
        this.edgeTo = new int[G.V()];
        this.visited = new boolean[G.V()];
        this.start = v;

        bfs(G, this.start);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(s);
        visited[s] = true;
        while (!todo.isEmpty()) {
            Integer v = todo.remove();
            for (Integer w : G.adjacencyList.get(v)) {
                if (!visited[w]) {
                    edgeTo[w] = v;
                    visited[w] = true;
                    todo.addAll(G.adjacencyList.get(w));
                }
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
