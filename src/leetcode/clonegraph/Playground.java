package leetcode.clonegraph;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.addAll(Arrays.asList(two, four));
        two.neighbors.addAll(Arrays.asList(one, three));
        three.neighbors.addAll(Arrays.asList(two, four));
        four.neighbors.addAll(Arrays.asList(one, three));
        Node cloned = cloneGraph.cloneGraph(one);
        System.out.println(cloned);
    }
}
