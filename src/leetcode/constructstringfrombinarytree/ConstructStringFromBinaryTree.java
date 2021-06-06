package leetcode.constructstringfrombinarytree;

import trees.TreeNode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode root, StringBuilder builder) {
        if (root != null) {
            builder.append(root.val);
            if (root.left != null && root.right != null) {
                builder.append("(");
                preOrder(root.left, builder);
                builder.append(")");
                builder.append("(");
                preOrder(root.right, builder);
                builder.append(")");
            } else if (root.left != null && root.right == null) {
                builder.append("(");
                preOrder(root.left, builder);
                builder.append(")");
            } else if (root.left == null && root.right != null) {
                builder.append("()");
                builder.append("(");
                preOrder(root.right, builder);
                builder.append(")");
            }
        }
    }
}
