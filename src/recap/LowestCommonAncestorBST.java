package recap;

import sun.reflect.generics.tree.Tree;
import trees.TreeNode;

public class LowestCommonAncestorBST {

    TreeNode lcabst(TreeNode root,
                    TreeNode a,
                    TreeNode b) {
        if (root.val > a.val && root.val > b.val) {
            return lcabst(root.left, a, b);
        } else if (root.val < a.val && root.val < b.val) {
            return lcabst(root.left, a, b);
        } else {
            return root;
        }
    }
}
