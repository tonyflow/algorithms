package leetcode.constructbtfrompreorderinorder;

import trees.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int preOrderPointer = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderNodeToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderNodeToIndex.put(inorder[i], i);
        }

        // preorder[0] is the root of the entire tree
        return construct(preorder, 0, inorder.length - 1, inOrderNodeToIndex);

    }

    private TreeNode construct(int[] preorder,
                               int nodeRangeStartInInOrderRA,
                               int nodeRangeEndInInOrderRA,
                               HashMap<Integer, Integer> inOrderNodeToIndex) {
        if (nodeRangeStartInInOrderRA <= nodeRangeEndInInOrderRA) {
            int rootVal = preorder[preOrderPointer];
            Integer rootIndexInInOrderRA = inOrderNodeToIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            preOrderPointer++;
            if (nodeRangeStartInInOrderRA < nodeRangeEndInInOrderRA) {
                root.left = construct(preorder, nodeRangeStartInInOrderRA, rootIndexInInOrderRA - 1, inOrderNodeToIndex);
                root.right = construct(preorder, rootIndexInInOrderRA + 1, nodeRangeEndInInOrderRA, inOrderNodeToIndex);
            }
            return root;
        } else {
            return null;
        }
    }
}
