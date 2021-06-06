package leetcode;

import trees.TreeNode;
import trees.Traversals;
import trees.BinarySearchTree;

public class InvertBinaryTree {

    // not a binary tree anymore though

    static public TreeNode invert(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            root.left = invert(root.left);
            root.right = invert(root.right);
        }

        return root;
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(4);
        binarySearchTree.put(2);
        binarySearchTree.put(7);
        binarySearchTree.put(1);
        binarySearchTree.put(3);
        binarySearchTree.put(6);
        binarySearchTree.put(9);

        Traversals.inOrder(binarySearchTree.root);

        TreeNode inverted = InvertBinaryTree.invert(binarySearchTree.root);
        System.out.println("===================");
        Traversals.inOrder(binarySearchTree.root);
    }
}
