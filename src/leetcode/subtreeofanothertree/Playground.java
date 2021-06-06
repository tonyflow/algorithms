package leetcode.subtreeofanothertree;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
//        TreeNode root = BinarySearchTree.createBT(new Integer[]{3, 4, 5, 1, 2, null, null, 0});
//        TreeNode root = BinarySearchTree.createBT(new Integer[]{3,4,5,1,2,null,null,0});
//        TreeNode root = BinarySearchTree.createBT(new Integer[]{1, 1});
        TreeNode root = BinarySearchTree.createBT(new Integer[]{3, 4, 5, 1, null, 2});

        TreeNode subRoot = BinarySearchTree.createBT(new Integer[]{3,1,2});
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(root, subRoot));
    }
}
