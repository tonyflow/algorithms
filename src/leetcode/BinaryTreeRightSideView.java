package leetcode;

import trees.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> levels = new HashMap<>();
        traverse(root, 0, levels);
        return levels.values().stream().collect(Collectors.toList());
    }

    private void traverse(TreeNode root,
                          int level,
                          Map<Integer, Integer> levels) {
        if (root != null) {
            levels.putIfAbsent(level, root.val);
            traverse(root.right, level + 1, levels);
            traverse(root.left, level + 1, levels);
        }
    }
}
