package leetcode.numwaystogoupastaircase;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class NumWaysToGoUpAStaircase {

    private int total = 0;
    private Map<Integer, Integer> memo = new HashMap<>();

    int find(int stairs) {
        if (stairs > 0) {
            int oneStep;
            if (memo.containsKey(stairs - 1)) {
                oneStep = memo.get(stairs - 1);
            } else {
                oneStep = find(stairs - 1);
                memo.put(stairs - 1, oneStep);
            }

            int twoSteps;
            if (memo.containsKey(stairs - 2)) {
                twoSteps = memo.get(stairs - 2);
            } else {
                twoSteps = find(stairs - 2);
                memo.put(stairs - 2, twoSteps);
            }
            return oneStep + twoSteps;
        } else if (stairs == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void doFind(int sum, int stairs) {
        if (sum == stairs) {
            total++;
            return;
        }
        if (sum < stairs) {
            doFind(sum + 1, stairs);
            doFind(sum + 2, stairs);
        }
    }
}
