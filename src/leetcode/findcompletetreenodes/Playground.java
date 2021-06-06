package leetcode.findcompletetreenodes;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        FindCompleteTreeNodes findCompleteTreeNodes = new FindCompleteTreeNodes();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(findCompleteTreeNodes.countNodes(root));
    }
}
