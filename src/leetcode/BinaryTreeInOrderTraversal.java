package leetcode;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> values = new LinkedList<>();
        inOrder(root, values);
        return values;
    }

    private void inOrder(TreeNode root, LinkedList<Integer> values) {
        if (root != null) {
            inOrder(root.left,values);
            values.add(root.val);
            inOrder(root.right,values);
        }
    }
}
