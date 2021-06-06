package facebook;

import java.util.Arrays;

public class LongestIncreasingSequenceAfterDeletingAtMostOneCharacter {

    static int brute(int[] nums) {
        // By removing each letter check which is the longest increasing subsequence that
        // we can create
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxCurrent = 1;
            int runningLength = 1;
            int current = 1;
            while (current < nums.length) {
                // This check skips that
                if (current != i) {
                    if (nums[current - 1] < nums[current]) {
                        runningLength++;
                    } else {
                        maxCurrent = Math.max(maxCurrent, runningLength);
                        runningLength = 1;
                    }
                    current++;
                }
            }
            max = Math.max(maxCurrent, max);
        }

        return max;
    }


    static int compute(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] intermediate = new int[nums.length];
        Arrays.fill(pre, 1);
        Arrays.fill(post, 1);

        post[post.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                post[i] += post[i + 1];
            } else {
                post[i] = 1;
            }
        }

        pre[0] = 1;
        for (int i = 1; i < pre.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pre[i] += pre[i - 1];
            } else {
                pre[i] = 1;
            }
        }

        // Calculate the length of the maximum increasing subarray without deleting any numbers
        int max = 1;
        int runningLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                runningLength++;
            } else {
                runningLength = 1;
            }
            max = Math.max(runningLength, max);
        }

        for (int i = 1; i < intermediate.length - 1; i++) {
            max = Math.max(max, pre[i - 1] + post[i + 1]);
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(compute(new int[]{1, 2, 5, 3, 4}));
        System.out.println(compute(new int[]{1, 10, 5, 6, 12, 20, 5}));
        System.out.println(brute(new int[]{1, 10, 5, 6, 12, 20, 5}));
    }
}
