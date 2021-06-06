package leetcode.lowestcommonancestor;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
//        Node lca = lowestCommonAncestorOfABinaryTree.lca(root, root.left.right.right, root.left.left);
//        System.out.println(lca.value);

        TreeNode lca2 = lowestCommonAncestorOfABinaryTree.lcaBetterSpaceComplexity(root, root.left, root.right);
        System.out.println(lca2.val);

    }
}
