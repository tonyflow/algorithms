package leetcode.hard.serializeanddeserializebinarytree;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTreeRuntimeErrorForLargeInput serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTreeRuntimeErrorForLargeInput();
        traverse(serializeAndDeserializeBinaryTree.deserialize("123--45"));
    }

    private static void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            System.out.println(root.val);
            traverse(root.right);
        }
    }
}
