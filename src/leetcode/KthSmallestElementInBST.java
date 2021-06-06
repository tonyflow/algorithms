package leetcode;

import trees.TreeNode;

import java.util.PriorityQueue;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        inOrder(root, queue, k);
        while (k - 1 > 0) {
            queue.poll();
            k--;
        }

        return queue.poll();
    }

    private void inOrder(TreeNode root, PriorityQueue<Integer> queue, int k) {
        if (root != null && queue.size() < k) {
            inOrder(root.left, queue, k);
            queue.offer(root.val);
            inOrder(root.right, queue, k);
        }
    }
}
