package leetcode;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) q.add(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> partial = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (reverse) {
                    partial.add(0, node.val);
                } else {
                    partial.add(node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(partial);

            reverse = !reverse;
            System.out.println(reverse);
            System.out.println(q.stream().map(n -> n.val).collect(Collectors.toList()));
        }

        return result;
    }
}
