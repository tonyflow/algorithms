package leetcode;

import trees.TreeNode;

import java.util.*;

public class LevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode levelNode = queue.poll();
                level.add(levelNode.val);
                if (levelNode.left != null) queue.add(levelNode.left);
                if (levelNode.right != null) queue.add(levelNode.right);
            }
            stack.add(level);
        }
        while (!stack.isEmpty()) result.add(stack.pop());

        return result;
    }
}
