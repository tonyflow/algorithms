package trees;

public class FlattenBTToLinkedList {

    void flatten(TreeNode root) {

        if (root == null) return;

        if (root.left == null && root.right == null) return;

        if (root.left != null) {
            flatten(root.left);

            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;

        }
    }

    public static void main(String[] args) {


    }
}
