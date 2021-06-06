package leetcode.convertbsttogreatertree;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        TreeNode root = BinarySearchTree.createBT(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        ConvertBSTToGreaterTree convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
        convertBSTToGreaterTree.convertBST(root);
    }
}
