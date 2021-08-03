package algorithms;

public class Dijkstra {

    /**
     * @param source Starting point of the algorithm - will find shortest paths from this node to all other nodes of the graph
     * @param graph  2 dimensional array - if graph[u][v] == (sentinel value) Integer.MAX_VALUE or 0 or if the graph does not
     *               contain negative weights then -1 then there is no edge, otherwise this is the weight of the edge.
     * @param V      Number of vertices
     * @return Distance array including the distance of i node from source at distance[i]
     */
    public int[] shortestPathsFromSource(int source,
                                         int[][] graph,
                                         int V) {

        // true if node i in the spanning tree
        boolean[] sptTree = new boolean[V];

        // distance from source
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            sptTree[i] = false;
        }

        distance[source] = 0;

        for (int v = 0; v < V; v++) {

            int u = findNextMinimum(sptTree, V, distance);

            for (Integer w : graph[u]) {
                if (!sptTree[w] && distance[u] + graph[u][w] < distance[w])
                    distance[w] = distance[u] + graph[u][w];
            }
        }

        return distance;
    }

    private int findNextMinimum(boolean[] sptTree,
                                int V,
                                int[] distance) {
        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (!sptTree[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
