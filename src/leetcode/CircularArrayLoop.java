package leetcode;

import java.util.*;

public class CircularArrayLoop {

    static boolean loop(int[] nums) {
        Stack<Integer> dfs = new Stack<>();
        int length = nums.length;
        boolean[] visited = new boolean[length];

        // Check positive seqs
        Map<Integer, Integer> positiveSeqs = new HashMap<>();
        Map<Integer, Integer> negativeSeqs = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                positiveSeqs.put(i, ((i + nums[i]) % length + length) % length);
            } else {
                negativeSeqs.put(i, ((i + nums[i]) % length + length) % length);
            }
        }

        // DFS in positives
        if (positiveSeqs.size() > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 && !visited[i]) {
                    dfs.push(i);
                    int pathLength = 0;
                    while (!dfs.isEmpty()) {
                        Integer popped = dfs.pop();
                        if (visited[popped] && pathLength > 1) {
                            // Found cycle
                            // Check size of cycle
                            // If size of cycle is greater than 1 return true
                            // else continue searching
                            return true;
                        } else {
                            visited[popped] = true;
                            if (positiveSeqs.containsKey(popped) && popped != positiveSeqs.get(popped)) {
                                dfs.push(positiveSeqs.get(popped));
                                pathLength++;
                            }
                        }
                    }
                    // Reset visited
                    Arrays.fill(visited, false);
                } else {
                    dfs.push(i);
                    int pathLength = 0;
                    while (!dfs.isEmpty()) {
                        Integer popped = dfs.pop();
                        if (visited[popped] && pathLength > 1) {
                            // Found cycle
                            // Check size of cycle
                            // If size of cycle is greater than 1 return true
                            // else continue searching
                            return true;
                        } else {
                            visited[popped] = true;
                            if (negativeSeqs.containsKey(popped) && popped != negativeSeqs.get(popped)) {
                                dfs.push(negativeSeqs.get(popped));
                                pathLength++;
                            }

                        }
                    }
                    // Reset visited
                    Arrays.fill(visited, false);
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(loop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(loop(new int[]{-1, 2}));
        System.out.println(loop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(loop(new int[]{-1, -2, -3, -4, -5}));
        System.out.println(loop(new int[]{-2, -3, -9}));
    }
}
