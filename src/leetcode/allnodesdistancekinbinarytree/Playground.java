package leetcode.allnodesdistancekinbinarytree;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {

        //[1]
        //1
        //3
        TreeNode single = new TreeNode(3);

        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(5);
        head.left.left = new TreeNode(6);
        head.left.right = new TreeNode(2);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(4);

        head.right = new TreeNode(1);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(8);

        AllNodesDistanceKInBinaryTree allNodesDistanceKInBinaryTree = new AllNodesDistanceKInBinaryTree();
        allNodesDistanceKInBinaryTree.distanceK(single, single, 3);

    }
}
