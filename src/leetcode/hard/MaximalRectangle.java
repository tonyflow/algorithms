package leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        // Array keeping the histogram created as we are traversing through the crows
        int[] helper = new int[matrix[0].length];
        Arrays.fill(helper, 0);

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {

            // Copy row elements to helper array to form a histogram
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') helper[j] += 1;
                else helper[j] = 0;
            }

            int iterationMax = Integer.MIN_VALUE;
            // Find maximum rectangle in histogram
            for (int j = 0; j < helper.length; j++) {

                while (!stack.isEmpty() && helper[stack.peek()] > helper[j]) {
                    Integer popped = stack.pop();

                    if (stack.isEmpty())
                        iterationMax = Math.max(iterationMax, helper[popped] * j);
                    else
                        iterationMax = Math.max(iterationMax, helper[popped] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }

            while (!stack.isEmpty()) {
                Integer popped = stack.pop();

                if (stack.isEmpty())
                    iterationMax = Math.max(iterationMax, helper[popped] * helper.length);
                else
                    iterationMax = Math.max(iterationMax, helper[popped] * (helper.length - stack.peek() - 1));
            }

            // At this point we have found the maximum rectangle formed till row i so we can update the result
            result = Math.max(result, iterationMax);
        }
        return result;
    }
}
