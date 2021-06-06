package leetcode;

public class NumberOfOnes {

    public int hammingWeight(int n) {
        int weight = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) weight++;
            mask <<= 1;
        }
        return weight;
    }
}
