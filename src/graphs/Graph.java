package graphs;

import java.util.*;

public class Graph {

    private int edges;
    private int vertices;

    // Adjacency list
    Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.edges = 0;
        this.vertices = 0;
    }

    /*
    It's a bidirectional Graph - undirected
     */
    public void addEdge(int a, int b) {
        doAddEdge(a, b);
        doAddEdge(b, a);
        this.edges++;
    }

    public void doAddEdge(int a, int b) {
        if (adjacencyList.containsKey(a)) {
            adjacencyList.get(a).add(b);
        } else {
            Set<Integer> neigh = new HashSet<>();
            neigh.add(b);
            adjacencyList.put(a, neigh);
        }
    }

    public void print() {
        adjacencyList.forEach(
                (a, neigh) -> System.out.println("Edge " + a + " is connected to " + neigh.toString())
        );
    }


    public int E() {
        return this.edges;
    }

    public int V() {
        return this.adjacencyList.keySet().size();
    }

}
