package leetcode.mergebinarytree;

import trees.TreeNode;
import trees.Traversals;

public class Playground {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.left.left = new TreeNode(5);
        a.right = new TreeNode(2);

        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(1);
        b.left.right = new TreeNode(4);
        b.right = new TreeNode(3);
        b.right.right = new TreeNode(7);

        MergeBinaryTrees mergeBinaryTrees = new MergeBinaryTrees();
        TreeNode merged = mergeBinaryTrees.merge(a, b);
        Traversals.postOrder(merged);
    }
}
