package leetcode.constructmaximumbinarytree;

import leetcode.constructbinarytreefrompostorderandinordertraversal.ConstructBinaryTreeFromPostorderAndInorderTraversal;
import leetcode.convertsortedlisttobinarysearchtree.ConvertSortedListToBinarySearchTree;

public class Playground {

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] test = {3, 2, 1, 6, 0, 5};
        maximumBinaryTree.constructMaximumBinaryTree(test);
    }
}
