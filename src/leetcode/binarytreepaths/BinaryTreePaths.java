package leetcode.binarytreepaths;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        Stack<Integer> fromRoot = new Stack<>();
        traverse(root, fromRoot, paths);

        return paths.stream().map(
                path -> path.stream().map(node -> Integer.toString(node)
                ).collect(Collectors.joining("->"))).collect(Collectors.toList());
    }

    private void traverse(TreeNode root,
                          Stack<Integer> path,
                          List<List<Integer>> paths) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(new ArrayList<>(path));
            } else {
                traverse(root.left, path, paths);
                traverse(root.right, path, paths);
            }
            path.pop();
        }
    }
}
