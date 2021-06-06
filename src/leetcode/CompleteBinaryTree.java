package leetcode;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    static boolean isComplete(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean isComplete = false;

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                isComplete = true;
            } else {
                if (isComplete) return false;
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
        }

        return isComplete;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(CompleteBinaryTree.isComplete(root));
    }
}
