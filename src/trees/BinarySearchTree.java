package trees;

public class BinarySearchTree {

    public TreeNode root;

    public static TreeNode createBT(Integer[] nums) {
        return create(nums, 0);
    }

    /**
     * Create a Binary tree from a integer array
     */
    private static TreeNode create(Integer[] nums, int start) {
        if (start < nums.length) {
            TreeNode root;
            if (nums[start] == null) {
                root = null;
            } else {
                root = new TreeNode(nums[start]);
                root.left = create(nums, 2 * start + 1);
                root.right = create(nums, 2 * start + 2);
            }

            return root;
        } else {
            return null;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode root) {
        if (root == null) return 0;
        else return root.size;
    }

    // this is more like an exist since the nodes have no keys here
    public TreeNode get(int value) {
        return get(root, value);
    }

    private TreeNode get(TreeNode root, int value) {
        if (root == null) return null; // something that indicates that they key was not found here
        else if (root.val == value) return root;
        else if (value < root.val) return get(root.left, value);
        else return get(root.right, value);
    }

    public void put(int value) {
        this.root = put(root, value);
    }

    private TreeNode put(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        else if (root.val > value) root.left = put(root.left, value);
        else if (root.val < value) root.right = put(root.right, value);
        else root.val = value;

        return root; //  there is already a node with the specified value
    }

    public int height() {
        return findHeight(root);
    }

    private int findHeight(TreeNode n) {
        if (n == null) return 0;
        else {
            return Math.max(findHeight(n.left), findHeight(n.right)) + 1;
        }

    }


}
