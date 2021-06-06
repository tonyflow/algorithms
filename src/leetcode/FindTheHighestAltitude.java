package leetcode;

public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int runningGain = 0;
        for (int i : gain) {
            max = Math.max(runningGain+=i,max);
        }
        return max;
    }
}
