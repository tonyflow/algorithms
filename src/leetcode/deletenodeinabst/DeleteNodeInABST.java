package leetcode.deletenodeinabst;

import trees.TreeNode;

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, null, key);
    }

    private TreeNode delete(TreeNode root,
                            TreeNode parent,
                            int key) {
        if (root != null) {
            if (root.val == key) {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    // both children are not null so
                    // find the min of the right subtree
                    int minFromRight = findMin(root.right);
                    root.val = minFromRight;
                    root.right = deleteNode(root.right, minFromRight);

                    return root;
                }
            } else {
                if (root.val > key) {
                    root.left = delete(root.left, root, key);
                } else {
                    root.right = delete(root.right, root, key);
                }
                return root;
            }
        } else {
            return null;
        }
    }

    private int findMin(TreeNode root) {
        int min = Integer.MAX_VALUE;
        while (root != null) {
            min = Math.min(min, root.val);
            root = root.left;
        }

        return min;
    }

}
