package leetcode.hard;

import java.util.Stack;

public class TrappingRainWater {

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int trapUsingStack(int[] height) {

        Stack<Coordinate> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && stack.peek().y <= height[i]) {

                Coordinate popped = stack.pop();
                if (popped.y == 0) continue;

                int diffX = i - popped.x - 1;
                int diffY = Math.min(height[i], popped.y);
                water += diffX * diffY;
            }

            stack.push(new Coordinate(i, height[i]));
        }
        return water;
    }

    /**
     * Correct solution but gets TLE on large inputs. The complexity is O(max(heights)*heights.length)
     */
    public int trapWaterBruteForceByLayer(int[] heights) {

        int water = 0;

        // Find height max
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            max = Math.max(max, height);
        }

        for (int i = 1; i <= max; i++) {
            Integer lastNonZero = null;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] < i) continue;
                if (lastNonZero != null)
                    water += j - lastNonZero - 1;
                lastNonZero = j;
            }
        }

        return water;
    }

    /**
     * Another brute force approach
     * For each element in the array find the max element on the left and the max element on the right.
     * The volume of water that can be trapped at this point is min(maxLeft,maxRight) - height[i]
     */
    public int trapWaterBruteForceBar(int[] heights) {

        int water = 0;
        for (int i = 0; i < heights.length; i++) {
            // Find left max
            int leftMax = 0;
            for (int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, heights[j]);

            // Find right max
            int rightMax = 0;
            for (int j = i; j < heights.length; j++)
                rightMax = Math.max(rightMax, heights[j]);

            water += Math.min(leftMax, rightMax) - heights[i];
        }
        return water;
    }

    /**
     * Based on the previous solution
     */
    public int trapWaterDP(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        int water = 0;

        leftMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++)
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);

        rightMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);

        for (int i = 0; i < heights.length; i++)
            water += Math.min(leftMax[i], rightMax[i]) - heights[i];

        return water;
    }


}
