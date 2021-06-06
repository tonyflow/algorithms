package leetcode;

import trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AverageOfAllValuesInBinaryTree {

    public List<Double> bfs(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(sum / size);
        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, List<Integer>> levelToValues = new HashMap<>();
        traverse(root, levelToValues, 0);
        return levelToValues.values().stream().map(nodes -> {
            int count = nodes.size();
            double sum = nodes.stream().mapToDouble(Double::valueOf).sum();
            return sum / count;
        }).collect(Collectors.toList());
    }

    private void traverse(TreeNode root,
                          HashMap<Integer, List<Integer>> levelToValues,
                          int level) {
        if (root != null) {
            if (levelToValues.containsKey(level)) {
                List<Integer> update = levelToValues.get(level);
                update.add(root.val);
                levelToValues.put(level, update);
            } else {
                ArrayList<Integer> update = new ArrayList<>();
                update.add(root.val);
                levelToValues.put(level, update);
            }
            traverse(root.left, levelToValues, level + 1);
            traverse(root.right, levelToValues, level + 1);
        }
    }
}
