package leetcode.deletenodeinabst;

import trees.BinarySearchTree;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        Integer[] bst = {5,3,6,2,4,null,7};
        TreeNode tree = BinarySearchTree.createBT(bst);
        DeleteNodeInABST deleteNodeInABST = new DeleteNodeInABST();
        deleteNodeInABST.deleteNode(tree,3);
    }
}
