package leetcode.houserobberiii;

import trees.TreeNode;

import java.util.*;

public class HouseRobberIII {

    // level order traversal
    Map<Pair, Integer> earnings = new HashMap<>();

    class Pair {
        TreeNode x;
        boolean include;

        public Pair(TreeNode x, boolean include) {
            this.x = x;
            this.include = include;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return include == pair.include && Objects.equals(x, pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, include);
        }
    }

    public int rob(TreeNode root) {
        return Math.max(doRob(root, false), doRob(root, true));
    }

    private int doRob(TreeNode root, boolean canRobCurrent) {
        if (root != null) {
            Pair canRobLeft = new Pair(root.left, true);
            Pair cannotRobLeft = new Pair(root.left, false);
            Pair canRobRight = new Pair(root.right, true);
            Pair cannotRobRight = new Pair(root.right, false);

            if (!earnings.containsKey(canRobLeft)) {
                earnings.put(canRobLeft, doRob(root.left, true));
            }

            if (!earnings.containsKey(canRobRight)) {
                earnings.put(canRobRight, doRob(root.right, true));
            }

            if (canRobCurrent) {
                // If we rob the current then we CANNOT rob its children since they are directly connected
                if (!earnings.containsKey(cannotRobLeft)) {
                    earnings.put(cannotRobLeft, doRob(root.left, false));
                }

                if (!earnings.containsKey(cannotRobRight)) {
                    earnings.put(cannotRobRight, doRob(root.right, false));
                }
                int robCurrent = root.val + earnings.get(cannotRobLeft) + earnings.get(cannotRobRight);

                // If we rob the current then we CAN rob its children since they are NOT directly connected


                int doNotRobCurrent = earnings.get(canRobLeft) + earnings.get(canRobRight);
                return Math.max(robCurrent, doNotRobCurrent);
            } else {
                // we cannot rob current so we can only explore the option without the current value as earnings
                return earnings.get(canRobLeft) + earnings.get(canRobRight);
            }
        } else return 0;
    }

}
