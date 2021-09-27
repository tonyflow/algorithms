package leetcode.medium;

public class GasStation {

    /**
     * This is greedy as fuck
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Figure out if there is a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) total += gas[i] - cost[i];
        if (total < 0) return -1;

        // Otherwise, there is definitely ONE solution
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

    public int quadratic(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int tank = 0 + gas[i] - cost[i];
            int nextGasStation = (i + 1) % gas.length;
            for (int j = nextGasStation; j == i - 1 && tank >= 0; j = (j + 1) % gas.length) {
                tank = tank + gas[j] - cost[j];
            }
            if (tank >= 0) return i;
        }
        return -1;
    }
}
