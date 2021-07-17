package leetcode.constructmaximumbinarytree;

import trees.TreeNode;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start <= end) {
            int maxIndex = findMax(nums, start, end);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = build(nums, start, maxIndex - 1);
            root.right = build(nums, maxIndex + 1, end);
            return root;
        } else return null;
    }

    private int findMax(int[] nums,
                        int start,
                        int end) {
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }
}
