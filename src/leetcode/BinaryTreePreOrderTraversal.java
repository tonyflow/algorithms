package leetcode;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> values = new LinkedList<>();
        preOrder(root, values);
        return values;
    }

    private void preOrder(TreeNode root, LinkedList<Integer> values) {
        if (root != null) {
            values.add(root.val);
            preOrder(root.left,values);
            preOrder(root.right,values);
        }
    }


}
