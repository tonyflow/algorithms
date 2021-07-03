package leetcode.binarysearchtreeiterator;

import trees.TreeNode;

import java.util.*;

public class BSTIteratorUsingQueue {

    Queue<Integer> nodes = new LinkedList<>();

    public BSTIteratorUsingQueue(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            nodes.add(root.val);
            inOrder(root.right);
        }
    }

    public int next() {
        return nodes.poll();
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }
}
