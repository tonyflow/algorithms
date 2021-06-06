package leetcode;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }

    private int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) bits++;
            mask <<= 1;
        }

        return bits;
    }
}
