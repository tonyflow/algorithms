package leetcode.constructstringfrombinarytree;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        TreeNode root = BinarySearchTree.createBT(new Integer[]{1, 2, 3, 4});
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        constructStringFromBinaryTree.tree2str(root);
    }
}
