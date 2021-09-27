package leetcode.medium;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {

    // 2,3,1
    // 1,3,2,4
    TreeNode toSwapA = null;
    TreeNode toSwapB = null;
    TreeNode previous = null;

    public void recoverTree(TreeNode root) {
        recover(root);
        int tmp = toSwapA.val;
        toSwapA.val = toSwapB.val;
        toSwapB.val = tmp;
    }

    private void recover(TreeNode root) {
        if (root != null) {
            recover(root.left);
            if (toSwapA == null && previous != null && previous.val >= root.val) toSwapA = previous;
            if (toSwapA != null && previous.val > root.val) toSwapB = root;
            previous = root;
            recover(root.right);
        }
    }

    /**
     * Working but slow
     */
    public void workingButSlow(TreeNode root) {

        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        List<Integer> sorted = new ArrayList(nodes);
        Collections.sort(sorted);

        int firstNodeValToBeSwapped = 0;
        int secondNodeValToBeSwapped = 0;

        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i) != nodes.get(i)) {
                firstNodeValToBeSwapped = sorted.get(i);
                secondNodeValToBeSwapped = nodes.get(i);
                break;
            }
        }

        swap(root, firstNodeValToBeSwapped, secondNodeValToBeSwapped);
    }

    private void swap(TreeNode root, int a, int b) {
        if (root != null) {
            swap(root.left, a, b);
            if (root.val == a) root.val = b;
            else if (root.val == b) root.val = a;
            swap(root.right, a, b);
        }
    }

    private void inOrder(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inOrder(root.left, nodes);
            nodes.add(root.val);
            inOrder(root.right, nodes);
        }
    }

}
