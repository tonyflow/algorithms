package leetcode.clonegraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        Map<Integer, Node> alreadyCloned = new HashMap<>();
        return doClone(node, alreadyCloned);

    }

    private Node doClone(Node node, Map<Integer, Node> alreadyCloned) {

        if (node == null) return null;

        Node clone = new Node(node.val);
        alreadyCloned.put(clone.val, clone);
        for (Node neighbor : node.neighbors) {
            if (alreadyCloned.containsKey(neighbor.val)) {
                clone.neighbors.add(alreadyCloned.get(neighbor.val));
            } else {
                clone.neighbors.add(doClone(neighbor, alreadyCloned));
            }
        }
        return clone;
    }

    private void dfs(Map<Integer, List<Integer>> adjacency, int source, Set<Integer> visited) {

        visited.add(source);
        for (Integer neighbor : adjacency.get(visited)) {
            if (!visited.contains(neighbor)) {
                dfs(adjacency, neighbor, visited);
            }
        }
    }

}
