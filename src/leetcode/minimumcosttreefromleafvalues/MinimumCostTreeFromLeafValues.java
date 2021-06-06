package leetcode.minimumcosttreefromleafvalues;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumCostTreeFromLeafValues {

    int[][] memo;

    int minCost(int[] arr) {
        memo = new int[arr.length][arr.length];
        for (int[] memos : memo) {
            Arrays.fill(memos, -1);
        }
        return dp(arr, 0, arr.length - 1);
    }

    private int dp(int[] arr,
                   int start,
                   int end) {
        if (start >= end) return 0;
        if (memo[start][end] != -1) return memo[start][end];

        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int leftSubtreeSum = dp(arr, start, i);
            int rightSubtreeSum = dp(arr, i + 1, end);
            int maxFromLeftSideArray = max(arr, start, i);
            int maxFromRightSideArray = max(arr, i + 1, end);
            int rootValue = maxFromLeftSideArray * maxFromRightSideArray;
            res = Math.min(res, rootValue + leftSubtreeSum + rightSubtreeSum);

        }
        memo[start][end] = res;
        return res;
    }

    private int max(int[] arr, int start, int end) {
        Integer max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    /**
     * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/478708/RZ-Summary-of-all-the-solutions-I-have-learned-from-Discuss-in-Python
     */
    public int greedy(int arr[]) {
        List<Integer> A = new ArrayList<>();
        int res = 0;

        for (int num : arr) {
            A.add(num);
        }

        while (A.size() != 1) {
            int minIndex = A.indexOf(Collections.min(A));

            if (minIndex > 0 && minIndex < A.size() - 1) {
                res += A.get(minIndex) * Math.min(A.get(minIndex + 1), A.get(minIndex - 1));
            } else if (minIndex == 0) {
                res += A.get(minIndex) * A.get(minIndex + 1);
            } else {
                res += A.get(minIndex) * A.get(minIndex - 1);
            }

            A.remove(minIndex);
        }

        return res;
    }

    int monotonicStack(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(Integer.MAX_VALUE);
        int res = 0;
        for (int num : arr) {
            while (s.peek() <= num) {
                System.out.println(s.stream().collect(Collectors.toList()));
                System.out.println("Top of the stack " + s.peek());
                System.out.println(s.peek() + " <= " + num);
                System.out.println("Popping " + s.peek());
                Integer popped = s.pop();
                System.out.println("res = " + res + " + " + popped + " * " + Math.min(s.peek(), num));
                res += popped * Math.min(s.peek(), num);
                System.out.println("res = " + res);
                System.out.println("=======================================");
            }
            s.push(num);
        }

        while (s.size() > 2) res += s.pop() + s.peek();
        return res;
    }

    int monotonicStack2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                Integer popped = stack.pop();
                if (stack.isEmpty()) {
                    res += popped * num;
                } else {
                    res += popped * Math.min(num, stack.peek());
                }
            }
            stack.push(num);
        }
        while (stack.size() > 1) res += stack.pop() * stack.peek();

        return res;
    }
}