package februaryreset.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    public Map<Integer, Set<Integer>> adjList;

    private Integer maxDegree = 0;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public Integer V() {
        return this.adjList.size();
    }

    public Integer E() {
        int edges = 0;
        for (Set<Integer> e : this.adjList.values()) {
            edges += e.size();
        }
        return edges;
    }


    public void addEdge(int a, int b) {
        Integer degreeA = doAddEdge(a, b);
        Integer degreeB = doAddEdge(b, a);
        this.maxDegree = Math.max(degreeA, degreeB);
    }

    public Integer selfLoops() {
        Integer selfLoops = 0;
        for (Map.Entry<Integer, Set<Integer>> e : this.adjList.entrySet()) {
            if (e.getValue().contains(e.getKey())) selfLoops++;
        }

        return selfLoops;
    }

    private Integer doAddEdge(int a, int b) {
        if (adjList.containsKey(a)) {
            adjList.get(a).add(b);
            return adjList.get(a).size();
        } else {
            Set<Integer> neigh = new HashSet<>();
            neigh.add(b);
            adjList.put(a, neigh);
            return 1;
        }
    }

    public Integer degree(int a) {
        if (adjList.containsKey(a)) {
            return adjList.get(a).size();
        }

        return 0;
    }

    public Integer maxDegree() {
        return this.maxDegree;
    }
}
