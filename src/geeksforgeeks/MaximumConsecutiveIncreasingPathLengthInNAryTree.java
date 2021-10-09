package geeksforgeeks;

import java.util.Map;

public class MaximumConsecutiveIncreasingPathLengthInNAryTree {

    class NaryTreeNode {
        Map<NaryTreeNode, Integer> childrenToWeights;
    }

    int globalMax = Integer.MIN_VALUE;

    int maximumIncreasingPath(NaryTreeNode root) {
        doFind(root, Integer.MIN_VALUE);
        return globalMax;
    }

    private int doFind(NaryTreeNode root, int previous) {
        if (root != null) {
            int max = 1;
            for (Map.Entry<NaryTreeNode, Integer> childToWeight : root.childrenToWeights.entrySet()) {
                if (childToWeight.getValue() > previous) {
                    max = Math.max(max, 1 + doFind(childToWeight.getKey(), childToWeight.getValue()));
                } else {
                    globalMax = Math.max(globalMax, doFind(childToWeight.getKey(), Integer.MIN_VALUE));
                }
            }

            globalMax = Math.max(globalMax, max);
            return max;
        }
        return 0;
    }
}
