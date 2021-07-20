package leetcode.allnodesdistancekinbinarytree;

import trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Set<Integer> result = new HashSet<>();

        // Turn the tree into a graph
        Map<TreeNode, Set<TreeNode>> graph = traverse(root);
        HashSet<Object> V = new HashSet<>();
        V.addAll(graph.keySet());
        for(Set<TreeNode> adjacent : graph.values()){
            V.addAll(adjacent);
        }
        boolean[] visited = new boolean[501];
        dfs(graph, target, 0, k, visited, result);

        return result.stream().collect(Collectors.toList());

    }

    private void dfs(Map<TreeNode, Set<TreeNode>> graph,
                     TreeNode root,
                     int distance,
                     int k,
                     boolean[] visited,
                     Set<Integer> result) {
        visited[root.val] = true;

        if (distance == k) {
            result.add(root.val);
            return;
        }

        Set<TreeNode> adjacent = graph.get(root);
        if (adjacent != null && !adjacent.isEmpty()) {
            for (TreeNode v : adjacent) {
                if (!visited[v.val])
                    dfs(graph, v, distance + 1, k, visited, result);
            }
        }
    }

    private Map<TreeNode, Set<TreeNode>> traverse(TreeNode root) {
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = q.poll();
                if (polled.left != null) {
                    addEdge(graph, polled, polled.left);
                    addEdge(graph, polled.left, polled);
                    q.add(polled.left);
                }

                if (polled.right != null) {
                    addEdge(graph, polled, polled.right);
                    addEdge(graph, polled.right, polled);
                    q.add(polled.right);
                }
            }
        }

        return graph;
    }

    private void addEdge(Map<TreeNode, Set<TreeNode>> graph, TreeNode from, TreeNode to) {
        if (graph.containsKey(from)) {
            graph.get(from).add(to);
        } else {
            Set<TreeNode> adjacent = new HashSet<>();
            adjacent.add(to);
            graph.put(from, adjacent);
        }
    }


    public List<Integer> deadEnd(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        Map<Integer, Set<TreeNode>> nodesByLevel = new HashMap<>();
        q.add(root);

        int depth = 0;
        int targetLevel = 0;
        while (!q.isEmpty()) {
            Set<TreeNode> level = new HashSet<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = q.poll();
                level.add(polled);
                if (polled.right != null) q.add(polled.right);
                if (polled.left != null) q.add(polled.left);
            }

            nodesByLevel.put(depth, level);
            if (level.contains(target))
                targetLevel = depth;
            depth++;
        }

        Set<TreeNode> leftChildren = new HashSet<>();
        collect(root.left, leftChildren);
        Set<TreeNode> rightChildren = new HashSet<>();
        collect(root.right, rightChildren);

        Set<TreeNode> targetSubtree = leftChildren.contains(target) ? leftChildren : rightChildren;

        for (Map.Entry<Integer, Set<TreeNode>> levelNodes : nodesByLevel.entrySet()) {
            int level = levelNodes.getKey();
            Set<TreeNode> nodes = levelNodes.getValue();
            // targetLevel + level if the belong to different sub trees
            // targetLevel - level == k if they belong to the same subtree
            for (TreeNode node : nodes) {
                if ((targetSubtree.contains(node) && targetLevel - level == k) ||
                        (targetSubtree.contains(node) && level - targetLevel == k) ||
                        (targetSubtree.contains(node) && level + targetLevel == k && node != target) ||
                        (!targetSubtree.contains(node) && targetLevel + level == k))
                    result.add(node.val);
            }
        }

//        if (nodesByLevel.containsKey(targetLevel + k))
//            result.addAll(nodesByLevel.get(targetLevel + k).stream().map(node -> node.val).collect(Collectors.toList()));

        return new ArrayList<>(result);
    }

    private void collect(TreeNode root, Set<TreeNode> nodes) {
        if (root != null) {
            collect(root.left, nodes);
            nodes.add(root);
            collect(root.right, nodes);
        }
    }
}
