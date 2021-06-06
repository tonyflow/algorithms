package leetcode.copylistwithrandompointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    public Node copyRandomList(Node head) {

        Node dummy = new Node(Integer.MIN_VALUE);
        Node dummyCursor = dummy;

        Node current = head;
        // value pointed by random pointer to the node carrying the random pointer
        HashMap<Node, Node> oldToNew = new HashMap<>();


        while (current != null) {
            Node currentNewNode = new Node(current.val);
            oldToNew.put(current, currentNewNode);
            current = current.next;
            dummyCursor.next = currentNewNode;
            dummyCursor = dummyCursor.next;
        }

        current = head;
        while (current != null) {
            Node newCurrentRandom = oldToNew.get(current.random);
            Node newNode = oldToNew.get(current);
            newNode.random = newCurrentRandom;
            current = current.next;
        }

        return dummy.next;

    }
}
