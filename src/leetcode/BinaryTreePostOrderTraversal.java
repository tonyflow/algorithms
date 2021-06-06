package leetcode;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> values = new LinkedList<>();
        postOrder(root, values);
        return values;
    }

    private void postOrder(TreeNode root, LinkedList<Integer> values) {
        if (root != null) {
            postOrder(root.left,values);
            postOrder(root.right,values);
            values.add(root.val);
        }
    }


}
