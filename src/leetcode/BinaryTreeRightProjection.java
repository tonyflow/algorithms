package leetcode;

import trees.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeRightProjection {

    Map<Integer, TreeNode> levelToRightmost = new TreeMap<>();

    List<Integer> project(TreeNode root) {
        doProject(root, 0);
        return levelToRightmost.values().stream().map(node -> node.val).collect(Collectors.toList());
    }

    private void doProject(TreeNode root, int level) {
        if (root != null) {
            levelToRightmost.putIfAbsent(level, root);
            doProject(root.right, level + 1);
            doProject(root.left, level + 1);
        }
    }
}
