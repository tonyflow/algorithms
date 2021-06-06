package trees;

public class NaryNode {

    public NaryNode[] children;
    public int value;

    public NaryNode(int R, int value) {
        this.children = new NaryNode[R];
        this.value = value;
    }
}
