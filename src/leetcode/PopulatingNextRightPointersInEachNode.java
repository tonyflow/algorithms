package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connectWithoutExtraSpace(Node root) {
        Node start = root;
        while (start != null) {
            Node current = start;
            Node previous = null;
            while (current != null) {
                if (current.left != null)
                    current.left.next = current.right;
                if (previous != null) {
                    previous.next = current.right.next;
                }
                previous = current.right;
                current = current.next;
            }
            start = start.left;
        }
        return root;
    }


    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            Stack<Node> level = new Stack<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            while (!level.isEmpty()) {
                Node node = level.pop();
                if (next != null)
                    node.next = next;
                next = node;
            }
        }
        return root;
    }

}
