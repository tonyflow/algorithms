package leetcode;

import java.util.HashSet;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        int total = 0;
        HashSet<Character> jewelsSet = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) total++;
        }

        return total;
    }

}
