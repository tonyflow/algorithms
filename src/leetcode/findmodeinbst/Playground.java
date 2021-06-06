package leetcode.findmodeinbst;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        TreeNode bt = BinarySearchTree.createBT(new Integer[]{1, null, 2, null, null, 2, null});
        findModeInBinarySearchTree.findMode(bt);
    }
}
