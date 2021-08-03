package leetcode.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playground {

    public static void main(String[] args) {

        List<Integer> piles = new ArrayList<>();
        piles.add(1);
        piles.add(2);
        int pile = Collections.binarySearch(piles,5);
        System.out.println(pile);
        System.out.println(~pile);
        System.out.println(~pile);

    }
}
