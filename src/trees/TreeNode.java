package trees;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    int size; //size of the subtree rooted here

    public TreeNode(int val,
                    TreeNode left,
                    TreeNode right,
                    int size) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static void printLeaves(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.val);
        } else {
            printLeaves(root.left);
            printLeaves(root.right);
        }


    }
}
