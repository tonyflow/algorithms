package leetcode.hard.largestrectangleinhistogram;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /**
     * Works but TLEs
     */
    public int brute(int[] heights) {
        if (heights.length == 1) return heights[0];
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int iterationMin = Integer.MAX_VALUE;
            int width = 0;
            for (int j = i; j < heights.length; j++) {
                if (heights[j] == 0) {
                    width = 0;
                    iterationMin = Integer.MAX_VALUE;
                    continue;
                }
                iterationMin = Math.min(iterationMin, heights[j]);
                max = Math.max(max, iterationMin * (++width));
            }
        }
        return max;
    }


    /**
     * Detailed explanations
     * - https://abhinandandubey.github.io/posts/2019/12/15/Largest-Rectangle-In-Histogram.html
     */
    public int monotonic(int[] heights) {
        // We'll keep the indexes of the bars here
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer popped = stack.pop();
                if (stack.isEmpty())
                    // In case the stack is empty after popping this element then this means that there is no
                    // other element at the left of the popped one which is smaller than the popped one - since the stack
                    // is monotonically increasing
                    result = Math.max(result, heights[popped] * i);
                else
                    result = Math.max(result, heights[popped] * (i - stack.peek()));
            }

            stack.push(i);
        }

        // There might be still elements left in the stack
        // For example in the case where a=[2,1,5,6,2,3], the last 2 and 3 will never get he chance to be popped
        // since they are in ascending order and there is no elements less than 3 after it. So we also have to factor
        // in these results
        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            if (stack.isEmpty())
                result = Math.max(result, heights[popped] * heights.length);
            else
                result = Math.max(result, heights[popped] * (heights.length - stack.peek() - 1));
        }
        return result;
    }
}
