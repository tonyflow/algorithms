package leetcode.flattenbinarytreetoalinkedlist;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        FlattenBinaryTreeToALinkedList flattenBinaryTreeToAList = new FlattenBinaryTreeToALinkedList();
        TreeNode root = BinarySearchTree.createBT(new Integer[]{1,2,5,3,4,null,6});
        flattenBinaryTreeToAList.extraSpace(root);
    }
}
