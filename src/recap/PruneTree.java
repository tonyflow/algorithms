package recap;

import trees.TreeNode;

public class PruneTree {

    TreeNode prune(TreeNode root) {

        if (root != null) {
            boolean containsOneLeft = checkContains(root.left);
            boolean containsOneRight = checkContains(root.right);

            if (!containsOneLeft) root.left = null;
            else {
                root.left = prune(root.left);
            }
            if (!containsOneRight) root.right = null;
            else {
                root.right = prune(root.right);
            }
        }

        return root;

    }

    boolean checkContains(TreeNode root) {
        if (root != null) {
            if (root.val == 1) return true;
            else {
                return checkContains(root.left) || checkContains(root.right);
            }
        }
        return false;
    }
}
