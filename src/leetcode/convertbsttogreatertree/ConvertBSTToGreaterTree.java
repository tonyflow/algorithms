package leetcode.convertbsttogreatertree;

import trees.TreeNode;

import java.util.ArrayList;

public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {

        ArrayList<Integer> nodes = new ArrayList<>();
        // Traverse the tree and create an ordered list
        traverse(root, nodes);

        // Create new values
        for (int i = nodes.size() - 1; i > 0; i--) {
            nodes.set(i - 1, nodes.get(i) + nodes.get(i - 1));
        }

        // Traverse and add
        traverseAndUpdate(root, nodes);
        return root;
    }

    private void traverseAndUpdate(TreeNode root, ArrayList<Integer> nodes) {
        if (root != null) {
            traverseAndUpdate(root.left, nodes);
            Integer headOfTheList = nodes.remove(0);
            root.val = headOfTheList;
            traverseAndUpdate(root.right, nodes);
        }
    }

    private void traverse(TreeNode root, ArrayList<Integer> nodes) {
        if (root != null) {
            traverse(root.left, nodes);
            nodes.add(root.val);
            traverse(root.right, nodes);
        }
    }
}
