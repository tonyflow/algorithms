package leetcode.hard.burstballoons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int[] m : memo) Arrays.fill(m, -1);
        return dp(nums, memo, 0, nums.length - 1);
    }

    private int dp(int[] nums,
                   int[][] memo,
                   int left,
                   int right) {
        if (left > right) return 0;

        if (memo[left][right] == -1) {
            int max = 0;

            for (int i = left; i <= right; i++) {
                int leftCell = left - 1 >= 0 ? nums[left - 1] : 1;
                int rightCell = right + 1 < nums.length ? nums[right + 1] : 1;
                int gain = leftCell * nums[i] * rightCell;
                int remaining = dp(nums, memo, left, i - 1) + dp(nums, memo, i + 1, right);
                max = Math.max(max, remaining + gain);
            }

            memo[left][right] = max;
        }

        return memo[left][right];
    }

    class MemoElement {
        int at;
        boolean[] visited;

        public MemoElement(int at, boolean[] visited) {
            this.at = at;
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoElement that = (MemoElement) o;
            return at == that.at && Arrays.equals(visited, that.visited);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(at);
            result = 31 * result + Arrays.hashCode(visited);
            return result;
        }
    }

    /**
     * Even using memoization makes this piece of shit fail
     */
    public int naive(int[] nums) {

        if (nums.length == 1) return nums[0];

        boolean[] visited = new boolean[nums.length];
        Map<MemoElement, Integer> memo = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, burst(nums, visited, i, memo));
        }

        return max;
    }

    private int burst(int[] nums,
                      boolean[] visited,
                      int index,
                      Map<MemoElement, Integer> memo) {
        if (!inBounds(index, nums)) return 0;

        MemoElement m = new MemoElement(index, Arrays.copyOf(visited, visited.length));
        if (!memo.containsKey(m)) {
            visited[index] = true;

            int max = 0;

            // Find left cell
            int leftCellIndex = index - 1;
            while (leftCellIndex >= 0 && visited[leftCellIndex]) leftCellIndex--;
            int leftCell = inBounds(leftCellIndex, nums) ? nums[leftCellIndex] : 1;

            // Find right cell
            int rightCellIndex = index + 1;
            while (rightCellIndex < nums.length && visited[rightCellIndex]) rightCellIndex++;
            int rightCell = inBounds(rightCellIndex, nums) ? nums[rightCellIndex] : 1;

            // Calculate coins
            int currentCell = leftCell * nums[index] * rightCell;

            // Recurse
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) max = Math.max(max, burst(nums, visited, i, memo));
            }

            visited[index] = false;
            memo.put(m, currentCell + max);
        }
        return memo.get(m);
    }

    private boolean inBounds(int index, int[] nums) {
        return index >= 0 && index < nums.length;
    }
}
