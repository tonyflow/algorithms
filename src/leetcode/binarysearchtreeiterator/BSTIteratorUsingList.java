package leetcode.binarysearchtreeiterator;

import trees.TreeNode;

import java.util.ArrayList;

public class BSTIteratorUsingList {
    ArrayList<TreeNode> nodes;
    int current;

    public BSTIteratorUsingList(TreeNode root) {
        nodes = new ArrayList();
        inOrder(root);
        this.current = 0;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            nodes.add(root);
            inOrder(root.right);
        }
    }

    public int next() {
        return nodes.get(current++).val;
    }

    public boolean hasNext() {
        return current < nodes.size();
    }
}
