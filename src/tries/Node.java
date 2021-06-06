package tries;

public class Node {

    Node[] children;

    /**
     * Size of the alphabet - For ASCII characters set to 256
     */
    int R;

    boolean isEndOfWord;

    public Node() {
        this.R = 256;
        this.children = new Node[R];
    }

    public Node(int R) {
        this.R = R;
        this.children = new Node[R];
    }
}
