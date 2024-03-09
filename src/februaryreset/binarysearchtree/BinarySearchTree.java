package februaryreset.binarysearchtree;

public abstract class BinarySearchTree<T extends Comparable<T>> {

    class Node {
        Node left;
        Node right;
        int value;

        // Size of the subtree rooted there;
        int N;

        public Node() {
            this.value = -1;
            this.N = 0;
        }

        public Node(int v) {
            this.value = v;
            this.N = 0;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = new Node();
    }

    public Node search(int v) {
        return search(this.root, v);
    }

    private Node search(Node n, int v) {
        if (n == null) return null;
        if (n.value == v) return n;
        else if (v > n.value) return search(n.right, v);
        else return search(n.left, v);
    }

    public void put(int v) {
        put(this.root, v);
    }

    public int size() {
        return this.root.N;
    }

    private int size(Node n) {
        return n.N;
    }

    private Node put(Node n, int v) {
        if (n == null) return new Node(v);
        if (v > n.value) n.right = put(n.right, v);
        else if (v < n.value) n.left = put(n.left, v);
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }
}
