package februaryreset.unionfind;

import java.util.Map;

public class UnionFind {

    class Node {
        int value;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    private Map<Integer, Node> uf;

    public UnionFind() {
    }

    public int union(int a, int b) {
        Node nodeA = this.uf.getOrDefault(a, null);
        Node nodeB = this.uf.getOrDefault(b, null);
        if (nodeA != null && nodeB != null) {
            Node repA = findRep(nodeA);
            Node repB = findRep(nodeB);

            // Union without any optimization
            if (repA.parent != repB && repB.parent != repA) {
                repA.parent = repB;
            }
        }

        // One of the two nodes is not in the structure
        return -1;
    }

    private Node findRep(Node current) {
        if (current == current.parent) return current;
        return findRep(current.parent);
    }

    public Node find(int v) {
        if (this.uf.containsKey(v)) {
            return findRep(this.uf.get(v));
        }

        return null;
    }
}
