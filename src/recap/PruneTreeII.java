package recap;

import trees.TreeNode;

public class PruneTreeII {

    TreeNode prune(TreeNode root) {

        if (root != null) {
            if (contains(root.left)) root.left = prune(root.left);
            else root.left = null;

            if (contains(root.right)) root.right = prune(root.right);
            else root.right = null;
        }

        return root;

    }

    boolean contains(TreeNode root) {
        if (root != null) return root.val == 1 || contains(root.left) || contains(root.right);
        return false;
    }

}
