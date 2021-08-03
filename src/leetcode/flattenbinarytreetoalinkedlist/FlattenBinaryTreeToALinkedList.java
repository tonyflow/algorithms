package leetcode.flattenbinarytreetoalinkedlist;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToALinkedList {

    public void flatten(TreeNode root) {

    }


    List<TreeNode> preOrderTraversal = new ArrayList<>();

    public void extraSpace(TreeNode root) {
        preOrder(root);
        for (int i = 0, j = 1; j < preOrderTraversal.size(); i++, j++) {
            TreeNode treeNodeI = preOrderTraversal.get(i);
            TreeNode treeNodeJ = preOrderTraversal.get(j);
            treeNodeI.right = treeNodeJ;
            treeNodeI.left = null;
        }
    }

    private void preOrder(TreeNode root) {
        if (root != null) {
            preOrderTraversal.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
