package leetcode.distributenodesinbt;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        DistributeCoinsInBT distributeCoinsInBT = new DistributeCoinsInBT();
        TreeNode head = new TreeNode(3);
        head.right = new TreeNode(0);
        head.left = new TreeNode(0);
        System.out.println(distributeCoinsInBT.find(head));
    }
}
