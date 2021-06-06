package leetcode.nextgreaterelement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    int[] nextGreaterNumber(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        HashMap<Integer, Integer> nums2ToIndex = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            nums2ToIndex.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = nums2ToIndex.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    int[] monotonicStack(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> nums2ToGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Populate nums2ToGreater using monotonic stack
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                Integer popped = stack.pop();
                nums2ToGreater.put(popped, nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            nums2ToGreater.put(popped, -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums2ToGreater.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
