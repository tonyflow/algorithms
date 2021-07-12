package leetcode;

import trees.NaryNode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostOrderTraversal {
    /**
     * Preorder
     * - root
     * - left
     * - right
     * <p>
     * Post order
     * - left
     * - right
     * - root
     * <p>
     * In order
     * - left
     * - root
     * - right
     */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(root, traversal);
        return traversal;
    }


    private void traverse(Node root, List<Integer> traversal) {
        if (root == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            traverse(root.children.get(i), traversal);
        }
        traversal.add(root.val);
    }
}
