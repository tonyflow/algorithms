package leetcode.hard.serializeanddeserializebinarytree;

import trees.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTreeRuntimeErrorForLargeInput {

    int V = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return null;

        Map<Integer, TreeNode> idToNode = new HashMap<>();
        idToNode.put(1, root);
        traverse(root, idToNode, 1);


        int[] keeper = new int[V + 1];

        StringBuilder builder = new StringBuilder();

        // The ids might range from 1 to V but in the string the indexes will range from 0 to V-1
        for (int i = 1; i < keeper.length; i++) {
            if (idToNode.get(i) == null) builder.append('*'); // * represents null child
            else builder.append(idToNode.get(i).val);
            builder.append(","); // , represents end of current node
        }

        if (builder.length() > 0) builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void traverse(TreeNode root,
                          Map<Integer, TreeNode> idToNode,
                          int id) {

        if (root != null) {
            V = Math.max(V, id);
            idToNode.put(id, root);
            traverse(root.left, idToNode, 2 * id);
            traverse(root.right, idToNode, 2 * id + 1);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] tokens = data.split(",");
        return doDeser(tokens, 0);
    }

    private TreeNode doDeser(String[] tokens, int index) {

        if (index < tokens.length) {
            String current = tokens[index];
            if (current.equals("*")) return null;
            else {
//                System.out.println(current);
//                System.out.println((int)current);
//                System.out.println(Integer.valueOf(current));
                TreeNode root = new TreeNode(Integer.parseInt(current + ""));
                root.left = doDeser(tokens, 2 * index + 1); // data is indexed while ids are 1 indexed
                root.right = doDeser(tokens, 2 * index + 1 + 1); // data is indexed while ids are 1 indexed

                return root;
            }
        }
        return null;
    }
}
