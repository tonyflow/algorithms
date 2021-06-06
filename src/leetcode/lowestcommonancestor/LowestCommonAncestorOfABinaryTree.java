package leetcode.lowestcommonancestor;

import trees.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    TreeNode answer = null;

    TreeNode lcaBetterSpaceComplexity(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lcaBetterSpaceComplexity(root.left, p, q);
        TreeNode right = lcaBetterSpaceComplexity(root.right, p, q);
        // Found both nodes in the subtrees below and I am the lowest
        // Check the case with an actual BT to understand why this is the case
        if (left != null && right != null) {
            return root;
        }

        // Otherwise we propagate the root of tree under which we found either p or q to the higher level of recursion
        return left == null ? right : left;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (root == p || root == q) return true;
            else {
                boolean dfsRight = dfs(root.right, p, q);
                boolean dfsLeft = dfs(root.left, p, q);
                if (dfsLeft && dfsRight) {
                    answer = root;
                }
                return dfsRight || dfsLeft;
            }
        }

        return false;
    }

    /**
     * High space complexity
     */
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> edgeTo = new HashMap<>();
        dfs(root, null, edgeTo);
        List<TreeNode> pathToP = find(p, edgeTo);
        Collections.reverse(pathToP);
        List<TreeNode> pathToQ = find(q, edgeTo);
        Collections.reverse(pathToQ);
        int minLength = Math.min(pathToP.size(), pathToQ.size());

        for (int i = 0; i < minLength; i++) {
            if (pathToP.get(i) != pathToQ.get(i)) {
                return pathToP.get(i - 1);
            }

        }
        return null;
    }

    private List<TreeNode> find(TreeNode s, Map<TreeNode, TreeNode> edgeTo) {
        List<TreeNode> path = new ArrayList<>();
        for (TreeNode next = s; next != null; next = edgeTo.get(next)) {
            path.add(next);
        }

        return path;
    }

    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> edgeTo) {
        if (root != null) {
            edgeTo.put(root, parent);
            dfs(root.left, root, edgeTo);
            dfs(root.right, root, edgeTo);
        }
    }
}
