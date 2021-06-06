package trees;

public class Traversals {

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.val);
        }
    }
}
