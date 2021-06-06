package leetcode.largestvalueineachtreerow;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        LargestValueInEachTreeRow largestValueInEachTreeRow = new LargestValueInEachTreeRow();
        TreeNode head = new TreeNode(4);
        head.right = new TreeNode(7);
        head.right.right = new TreeNode(9);
        head.right.left = new TreeNode(6);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);

        for (Integer max : largestValueInEachTreeRow.find(head)) {
            System.out.println(max);
        }
    }
}
