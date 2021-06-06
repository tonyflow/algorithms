package leetcode;

import java.util.Arrays;

public class NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] A) {
        int doubleN = A.length;
        int N = doubleN / 2;
        int[] counts = new int[10001];
        Arrays.fill(counts, 0);
        for (int i : A) {
            counts[i]++;
            if (counts[i] == N) return i;
        }

        return -1;
    }
}
