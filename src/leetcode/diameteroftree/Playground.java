package leetcode.diameteroftree;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        Integer[] integers = {14, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
//        System.out.println(integers.length);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3); // 1
        root.left.left = new TreeNode(4); // 2
        root.left.right = new TreeNode(5); // 3
//        root.right.right.left = new TreeNode(-4); // 4
//        root.right.left.right = new TreeNode(-7); // 5
//        root.right.right.left = new TreeNode(9); // 6
//        root.right.left.right.right = new TreeNode(-6); // 7
//        root.right.right.right.right.right.right.right.right = new TreeNode(-3); //
//        root.right.right.right.right.right.right.right.right.right = new TreeNode(-3);
        DiameterOfATree diameterOfATree = new DiameterOfATree();
        System.out.println(diameterOfATree.treeHeight(root));
//        System.out.println(diameterOfATree.diameterOfBinaryTree(root));
    }
}
