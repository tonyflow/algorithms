package leetcode;

import trees.TreeNode;

import java.util.ArrayList;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        traverse(root, inOrder);

        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) > inOrder.get(i + 1)) return false;
        }
        return true;
    }

    private void traverse(TreeNode root, ArrayList<Integer> inOrder) {
        if (root != null) {
            traverse(root.left, inOrder);
            inOrder.add(root.val);
            traverse(root.right, inOrder);
        }
    }

    public boolean isValidBST2(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                return root.left.val < root.val &&
                        root.right.val > root.val &&
                        isValidBST(root.left) &&
                        isValidBST(root.right);
            } else if (root.left == null && root.right != null) {
                return root.right.val > root.val &&
                        isValidBST(root.right);
            } else if (root.left != null && root.right == null) {
                return root.left.val < root.val &&
                        isValidBST(root.left);
            } else {
                return true;
            }
        }
        return true;
    }
}
