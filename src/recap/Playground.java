package recap;

import trees.TreeNode;

public class Playground {
    public static void main(String[] args) {
//        PruneTree pruneTree = new PruneTree();
//        Node head = new Node(1);
//        head.right = new Node(1);
//        head.right.right = new Node(1);
//        head.right.left = new Node(0);
//        Node prune = pruneTree.prune(head);
//        System.out.println(prune);

        BSTreeCompleteness bsTreeCompleteness = new BSTreeCompleteness();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(bsTreeCompleteness.isComplete(root));

    }
}
