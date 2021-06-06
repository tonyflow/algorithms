package leetcode;

import java.util.Arrays;

public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(banks -> Arrays.stream(banks).sum()).max(Integer::compareTo).get();
    }
}
