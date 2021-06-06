package leetcode.rangesumbst;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        TreeNode head = new TreeNode(10);
        head.right = new TreeNode(15);
        head.left = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(7);
        head.right.right = new TreeNode(18);
        System.out.println(rangeSumBST.find(head, 7, 15));
    }
}
