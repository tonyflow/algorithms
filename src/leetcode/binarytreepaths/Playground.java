package leetcode.binarytreepaths;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {
    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = BinarySearchTree.createBT(new Integer[]{1, 2, 3, null, 5});
        System.out.println(binaryTreePaths.binaryTreePaths(root));
    }
}
