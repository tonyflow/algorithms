package recap;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BSTreeCompleteness {

    Map<Integer, LinkedList<Integer>> levels = new TreeMap<>();

    boolean isComplete(TreeNode head) {
        traverse(head, 1, 0);

        boolean isComplete = true;
        int level = 0;
        while (level < levels.size() - 1) {
            LinkedList<Integer> nodes = levels.get(level);
            if (nodes.size() != Math.pow(2, level)) isComplete = false;
            level++;
        }

        boolean isLastLevelComplete = levels.get(level).size() == Math.pow(2, level) || levels.get(level).getLast() % 2 == 0;
        return isComplete && isLastLevelComplete;
    }

    private void traverse(TreeNode head, int id, int level) {
        if (head != null) {
            LinkedList<Integer> nodes;
            if (levels.containsKey(level)) {
                nodes = levels.get(level);
            } else {
                nodes = new LinkedList<>();
            }
            nodes.add(id);
            levels.put(level, nodes);

            traverse(head.left, 2 * id, level + 1);
            traverse(head.right, 2 * id + 1, level + 1);
        }
    }
}
