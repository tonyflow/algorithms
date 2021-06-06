package leetcode;

import trees.TreeNode;

import java.util.*;

/**
 * Find the leftmost value in the last row of the tree
 */
public class FindBottomLeftSubtree {


    int find(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            root = treeNode;
        }

        return root.val;
    }

}
