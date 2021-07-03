package leetcode.binarysearchtreeiterator;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIteratorUsingStackAndLessSpace {


    Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorUsingStackAndLessSpace(TreeNode root) {
        pushRootAndLeftChildren(root);
    }

    public int next() {
        TreeNode next = stack.pop();
        pushRootAndLeftChildren(next.right);
        return next.val;
    }

    private void pushRootAndLeftChildren(TreeNode root) {
        if (root != null) {
            stack.push(root);
            pushRootAndLeftChildren(root.left);
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
