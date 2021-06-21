package leetcode.flattenbinarytreetoalist;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToAList {

//    TreeNode dummy = new TreeNode(0);
//    TreeNode dummyTraversor = dummy;
    List<TreeNode> preOrderTraversal = new ArrayList<>();

    public void flatten(TreeNode root) {
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
