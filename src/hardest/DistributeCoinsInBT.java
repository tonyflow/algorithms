package hardest;

import trees.TreeNode;

public class DistributeCoinsInBT {

    int find(TreeNode head) {
        if (head != null) {
            return Math.abs(head.val - 1) + find(head.right) + find(head.left);
        } else {
            return 0;
        }
    }
}
