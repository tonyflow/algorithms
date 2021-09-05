package leetcode.hard.serializeanddeserializebinarytree;

import trees.TreeNode;

import java.util.*;

/**
 * Using preorder traversal
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        buildString(builder, root);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void buildString(StringBuilder builder, TreeNode root) {
        if (root == null) builder.append("X,");
        else {
            builder.append(root.val);
            builder.append(",");
            buildString(builder, root.left);
            buildString(builder, root.right);

        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<String> q = new LinkedList<>(
                Arrays.asList(
                        data.split(",")
                )
        );
        return reconstruct(q);
    }

    private TreeNode reconstruct(Queue<String> q) {
        String polled = q.poll();
        if (polled.equals("X")) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(polled));
            root.left = reconstruct(q);
            root.right = reconstruct(q);
            return root;
        }
    }
}
