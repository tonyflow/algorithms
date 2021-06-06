package leetcode.longestunivaluepath;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        LongestUniValuePath longestUniValuePath = new LongestUniValuePath();
//        Integer[] test = {5,4,5,1,1,5};
//        TreeNode root = BinarySearchTree.createBT(test);
//        System.out.println(longestUniValuePath.longestUnivaluePath(root));

        Integer[] test = {1,4,5,4,4,5};
        TreeNode root = BinarySearchTree.createBT(test);
        System.out.println(longestUniValuePath.longestUnivaluePath(root));
    }
}
