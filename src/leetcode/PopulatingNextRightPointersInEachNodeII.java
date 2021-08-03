package leetcode;

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {

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

    // No extra space
    public Node connect(Node root) {
        Node current = root;
        while (current != null) {
            Node levelCursor = current;
            Node previous = null;
            while (levelCursor != null) {

                if (levelCursor.left != null && previous != null) {
                    previous.next = levelCursor.left;
                }

                if (levelCursor.left != null) {
                    previous = levelCursor.left;
                }

                if (levelCursor.right != null && previous != null) {
                    previous.next = levelCursor.right;
                }

                if (levelCursor.right != null) {
                    previous = levelCursor.right;
                }

                levelCursor = levelCursor.next;
            }
            while (current != null && (current.left != null || current.right != null)) {
                if (current.left != null) {
                    current = current.left;
                    break;
                } else if (current.right != null) {
                    current = current.right;
                    break;
                } else {
                    current = current.next;
                }
            }

        }

        return root;
    }

    public Node connectCompleteTree(Node root) {
        Node current = root;
        while (current != null) {
            Node levelCursor = current;
            Node previous = null;
            while (levelCursor != null) {
                levelCursor.left.next = levelCursor.right;
                if (previous != null)
                    previous.next = levelCursor.left;
                previous = levelCursor.right;
                levelCursor = levelCursor.next;
            }

            current = current.left;
        }

        return root;
    }

    public Node extraSpace(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty()) {
            int size = q.size();

            Queue<Node> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node polled = q.poll();
                level.add(polled);
                if (polled.left != null) q.add(polled.left);
                if (polled.right != null) q.add(polled.right);
            }

            Node previous = null;
            while (!level.isEmpty()) {
                Node polled = level.poll();
                if (previous != null)
                    previous.next = polled;
                previous = polled;

            }
        }
        return root;
    }
}
