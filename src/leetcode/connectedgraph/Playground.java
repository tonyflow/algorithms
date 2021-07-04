package leetcode.connectedgraph;

public class Playground {

    public static void main(String[] args) {
        ConnectedGraph connectedGraph = new ConnectedGraph();
        int[][] connected = {
                {0, 4},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 4},
                {3, 1},
                {3, 2},
                {4, 3},

        };

        int[][] notConnected = {
                {0, 1},
                {2, 3}
        };
        System.out.println(connectedGraph.isConnected(connected));
        System.out.println(connectedGraph.isConnected(notConnected));
    }
}
