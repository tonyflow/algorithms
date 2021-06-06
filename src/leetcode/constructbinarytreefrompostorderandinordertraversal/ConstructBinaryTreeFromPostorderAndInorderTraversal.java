package leetcode.constructbinarytreefrompostorderandinordertraversal;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {

    Map<Integer, Integer> inOrderNodeToIndex = new HashMap<>();
    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inOrderNodeToIndex.put(inorder[i], i);
        }

        //inOrderNodeRangeStart
        return constructTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] postorder,
                                   int inOrderNodeRangeStart,
                                   int inOrderNodeRangeEnd) {
        if (inOrderNodeRangeStart <= inOrderNodeRangeEnd) {
            int rootVal = postorder[postOrderIndex];
            Integer rootValInOrderRAIndex = inOrderNodeToIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            postOrderIndex--;
            if (inOrderNodeRangeStart < inOrderNodeRangeEnd) {
                root.right = constructTree(postorder, rootValInOrderRAIndex + 1, inOrderNodeRangeEnd);
                root.left = constructTree(postorder, inOrderNodeRangeStart, rootValInOrderRAIndex - 1);
            }
            return root;
        } else {
            return null;
        }
    }
}
