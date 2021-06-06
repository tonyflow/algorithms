package leetcode;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    int paths = 0;

    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        // Create a presum and then traverse again while checking the presum
        createPreSum(root, targetSum, 0, sumToCount);
        int result = paths;
        paths = 0;

        return result;
    }

    private void createPreSum(TreeNode root,
                              int targetSum,
                              int runningSum,
                              Map<Integer, Integer> sumToCount) {
        if (root != null) {
            runningSum += root.val;
            if (sumToCount.containsKey(runningSum - targetSum)) {
                paths += sumToCount.get(runningSum - targetSum);
            }
            sumToCount.put(runningSum, sumToCount.getOrDefault(runningSum, 0) + 1);

            // Recurse on right and left subtree
            createPreSum(root.left, targetSum, runningSum, sumToCount);
            createPreSum(root.right, targetSum, runningSum, sumToCount);

            // Update running sum entry so that it does not conflict with higher order recursive calls
            sumToCount.put(runningSum, sumToCount.getOrDefault(runningSum, 0) - 1);
            if (sumToCount.get(runningSum) <= 0) sumToCount.remove(runningSum);
        }
    }

}
