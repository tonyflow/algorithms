package leetcode;

import java.util.Arrays;

public class KokoEatingBananas {

    static int minEatingSpeed(int[] piles, int h) {

        // Find max array and sum A
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int start = 1;
        int end = max;
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) >>> 1;

            // Using this middle try to figure out how many hours will take Koko to eat the bananas
            // from all the piles
            int[] pilesCopy = Arrays.copyOf(piles, piles.length);
            int currentPile = 0;
            int hoursNeeded = 0;
            for (int pile : piles) {
                hoursNeeded+=pile/middle;
                if(pile%middle!=0) hoursNeeded++;
            }
//            while (currentPile < pilesCopy.length) {
//                pilesCopy[currentPile] -= middle;
//                if (pilesCopy[currentPile] <= 0) {
//                    currentPile++;
//                }
//                hoursNeeded++;
//            }

            if (hoursNeeded <= h) {
                answer = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11},8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(minEatingSpeed(new int[]{312884470},312884469));
//        [312884470]
//        312884469
    }
}
