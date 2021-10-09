package algorithms.kdtree;

public class KDTree {

    KDNode root;
    int k;

    public KDTree(int k) {
        this.k = k;
    }

    public void insert(int[] value) {
        insert(value, this.root, 0);
    }

    private KDNode insert(int[] values,
                          KDNode root,
                          int depth) {
        if (root == null) {
            root = new KDNode(values);
            return root;
        }

        // Find dimension to compare
        int dimension = depth % k;
        if (values[dimension] < root.values[dimension])
            root.left = insert(values, root.left, depth + 1);
        else
            root.right = insert(values, root.right, depth + 1);

        return root;
    }

    public KDNode get(int[] values) {
        return get(values, this.root, 0);
    }

    private KDNode get(int[] values,
                       KDNode root,
                       int depth) {

        if (root == null) return null;

        if (equals(root.values, values)) return root;

        // Find dimension to compare
        int dimension = depth % k;

        if (values[dimension] < root.values[dimension])
            return get(values, root.left, depth + 1);

        return get(values, root.right, depth + 1);
    }

    private boolean equals(int[] a, int[] b) {
        for (int i = 0; i < k; i++)
            if (a[i] != b[i]) return false;

        return true;
    }


}
