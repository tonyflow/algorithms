package leetcode.hard.serializeanddeserializebinarytree;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class SerializeAndDeserializeBinaryTreeMemoryLimitExceeded {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return null;

        Map<Integer, TreeNode> idToNode = new HashMap<>();
        traverse(root, idToNode, 1);

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, TreeNode> e : idToNode.entrySet()) {
            builder.append(e.getKey() + "?" + e.getValue().val);
            builder.append(",");
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    private void traverse(TreeNode root,
                          Map<Integer, TreeNode> idToNode,
                          int id) {

        if (root != null) {
            idToNode.put(id, root);
            traverse(root.left, idToNode, 2 * id);
            traverse(root.right, idToNode, 2 * id + 1);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        // Create id to node map
        Map<Integer, Integer> idToNode = reconstructPartial(data);
        return reconstruct(idToNode, 1);
    }

    private TreeNode reconstruct(Map<Integer, Integer> idToNode, int id) {
        if (idToNode.containsKey(id)) {
            TreeNode root = new TreeNode(idToNode.get(id));
            root.left = reconstruct(idToNode, 2 * id);
            root.right = reconstruct(idToNode, 2 * id + 1);

            return root;
        }
        return null;
    }

    private Map<Integer, Integer> reconstructPartial(String data) {
        Map<Integer, Integer> keeper = new HashMap<>();
        String[] nodes = data.split(",");
        for (String node : nodes) {
            String[] info = node.split("\\?");
            int id = Integer.parseInt(info[0]);
            int val = Integer.parseInt(info[1]);
            keeper.put(id,val);
        }

        return keeper;
    }
}
