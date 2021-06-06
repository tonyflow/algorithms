package leetcode;

public class ReverseBits {

    /**
     * From here https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
     * Clean code and explanation
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result += 1;
            n >>= 1;
        }
        return result;
    }
}
