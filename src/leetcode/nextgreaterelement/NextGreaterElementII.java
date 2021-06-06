package leetcode.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    static int[] nextGreaterNumber(int[] nums) {
        int M = nums.length;
        int[] result = new int[M];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * M; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % M]) {
                Integer popped = stack.pop();
                result[popped] = nums[i % M];
            }
            stack.push(i % M);
        }

        return result;
    }

    static int[] inefficient(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        Arrays.fill(result, -1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N + i; j++) {
                if (nums[j % N] > nums[i]) {
                    result[i] = nums[j % N];
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] inefficientResult = inefficient(new int[]{1, 2, 1});
        int[] efficient = nextGreaterNumber(new int[]{1, 2, 1});
        int[] another = nextGreaterNumber(new int[]{1, 2, 3, 4, 3});
//        System.out.println(Arrays.toString(inefficientResult));
        System.out.println(Arrays.toString(another));

    }
}
