package leetcode;

import trees.TreeNode;

public class ConvertSortedArrayToBST {

    static TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private static TreeNode create(int[] nums,
                                   int start,
                                   int end) {
        if (start <= end) {
            int middle = (start + end) >>> 1;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = create(nums, start, middle - 1);
            root.right = create(nums, middle + 1, end);
            return root;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println("sagsafg");
    }
}
