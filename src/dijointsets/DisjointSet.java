package dijointsets;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    class Node {
        Node parent;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Map<Integer, Node> nodes = new HashMap<>();

    public void makeSet(int data) {
        Node node = new Node(data);
        node.parent = node;
        nodes.put(data, node);
    }

    public void union(int a, int b) {
        Node nodeA = nodes.get(a);
        Node nodeB = nodes.get(b);

        // Find representatives
        Node representativeA = find(nodeA);
        Node representativeB = find(nodeB);

        if (representativeA != representativeB) {
            representativeA.parent = representativeB;
        }
    }

    private Node find(Node node) {
        if (node.parent == node) return node;
        else {
            return find(node.parent);
        }
    }
}
