package leetcode;

public class MinimumChangesToMakeAlternatingBinaryString {

    /**
     * Inconclusive
     */
    public int formula(String s) {
        int ones = 0;
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        // Start with zero
        if (s.length() % 2 == 0) {

        }

        // Start with one
        if (s.length() % 2 == 0) {

        }

        return -1;
    }


    public int minOperations(String s) {

        // Start with 0
        int currentShouldBe = '0';
        int operationsWith0 = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) != currentShouldBe) {
                operationsWith0++;
            }

            if (i % 2 == 0) currentShouldBe = '0';
            else currentShouldBe = '1';
        }

        // Start with 1
        currentShouldBe = '1';
        int operationsWith1 = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) != currentShouldBe) {
                operationsWith1++;
            }

            if (i % 2 == 0) currentShouldBe = '1';
            else currentShouldBe = '0';
        }
        return Math.min(operationsWith0, operationsWith1);
    }
}
