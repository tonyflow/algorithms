package leetcode;

public class SingleNumber {

    /**
     * 0 XOR b = b
     * a XOR a = 0
     * a XOR b XOR a = a XOR a XOR b = 0 XOR b = b
     * If we XOR all numbers - sine all of them apart from one are duplicates - we will be left with the unique one
     *
     * 0 0 0 0
     * 1 0 1 0 XOR
     * 1 0 1 0
     *
     * 1 1 1 1
     * 1 0 1 0 XOR
     * 0 1 0 1
     *
     * 1 0 1 0
     * 1 0 1 0 XOR
     * 0 0 0 0
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a^=num;
        }

        return a;

    }
}
