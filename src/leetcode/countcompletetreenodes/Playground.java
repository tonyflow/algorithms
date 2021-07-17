package leetcode.countcompletetreenodes;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        System.out.println(countCompleteTreeNodes.countNodes(root));
        System.out.println(heightBasedOnNodes(root));
        System.out.println(findHeightRight(root));
        System.out.println(findHeightLeft(root));
    }

    private static int findHeightLeft(TreeNode root) {
        if (root != null) {
            return 1 + findHeightLeft(root.left);
        } else return 0;
    }

    private static int findHeightRight(TreeNode root) {
        if (root != null) {
            return 1 + findHeightRight(root.right);
        } else return 0;
    }

    private static int heightBasedOnNodes(TreeNode root) {
        if (root == null) return 0;
        else {
            int heightL = heightBasedOnNodes(root.left);
            int heightR = heightBasedOnNodes(root.right);
            return 1 + Math.max(heightL, heightR);
        }
    }

    private static int heightBasedOnEdges(TreeNode root) {
        if (root == null) return -1;
        else {
            int heightL = heightBasedOnEdges(root.left);
            int heightR = heightBasedOnEdges(root.right);
            return 1 + Math.max(heightL, heightR);
        }
    }
}
