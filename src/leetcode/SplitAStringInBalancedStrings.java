package leetcode;

public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int rCount = 0;
        int lCount = 0;
        int balancedString = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') lCount++;
            if (c == 'R') rCount++;
            if (lCount == rCount) {
                balancedString++;
                rCount = 0;
                lCount = 0;
            }
        }

        return balancedString;
    }
}
