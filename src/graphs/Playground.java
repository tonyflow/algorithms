package graphs;

public class Playground {


    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);

        g.print();

        DFS dfs = new DFS(g, 0);
        BFS bfs = new BFS(g, 0);

//        dfs.printEdgeTo();
//        System.out.println(dfs.hasPathTo(5));
//        System.out.println(dfs.pathTo(5));
//        System.out.println(dfs.pathTo(0));
//        System.out.println(dfs.pathTo(1));
//        System.out.println(dfs.pathTo(3));

        System.out.println(bfs.pathTo(5));
        System.out.println(bfs.pathTo(3));
    }
}
