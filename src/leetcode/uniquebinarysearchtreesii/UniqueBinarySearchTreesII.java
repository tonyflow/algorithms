package leetcode.uniquebinarysearchtreesii;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return create(1, n);
    }

    private List<TreeNode> create(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<>();
        if (start > end) trees.add(null);
        else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> rightTrees = create(i + 1, end);
                List<TreeNode> leftTrees = create(start, i - 1);
                for (TreeNode rightTree : rightTrees) {
                    for (TreeNode leftTree : leftTrees) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = leftTree;
                        treeNode.right = rightTree;
                        trees.add(treeNode);
                    }
                }
            }
        }
        return trees;
    }
}
