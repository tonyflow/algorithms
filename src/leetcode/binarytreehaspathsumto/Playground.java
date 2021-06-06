package leetcode.binarytreehaspathsumto;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);


        HasPathSum hasPathSum = new HasPathSum();
        System.out.println(hasPathSum.check(root,18));
    }
}
