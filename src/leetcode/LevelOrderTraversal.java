package leetcode;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    class NodeAndLevel {

        TreeNode treeNode;
        int level;

        public NodeAndLevel(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    void traverse(TreeNode root) {

        Queue<NodeAndLevel> queue = new LinkedList<>();
        Queue<NodeAndLevel> result = new LinkedList<>();

        queue.offer(new NodeAndLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.poll();
            result.offer(nodeAndLevel);
            if (nodeAndLevel.treeNode.left != null) {
                queue.offer(new NodeAndLevel(nodeAndLevel.treeNode.left, nodeAndLevel.level + 1));
            }

            if (nodeAndLevel.treeNode.right != null) {
                queue.offer(new NodeAndLevel(nodeAndLevel.treeNode.right, nodeAndLevel.level + 1));
            }
        }

        for (Map.Entry<Integer, List<NodeAndLevel>> level : result.stream().collect(Collectors.groupingBy(nodeAndLevel -> nodeAndLevel.level)).entrySet()) {
            System.out.println("Value on level " + level.getKey());
            level.getValue().forEach(node -> System.out.print(node.treeNode.val + " "));
            System.out.println("");
        }
    }

}
