package lists;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + val +
                '}';
    }
}
