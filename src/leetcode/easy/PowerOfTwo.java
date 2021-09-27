package leetcode.easy;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        int remainder;
        while (n != 1) {
            remainder = n % 2;
            if (remainder != 0) return false;
            n /= 2;
        }
        return true;

//        return ((n ^ (n - 1))==0 && n > 0);
    }
}
