package leetcode;

import java.util.Arrays;

public class ShortestDistanceToACharacter {

    /**
     * This is actually O(n)
     * We are traversing the array one time forwards and one time backwards
     */
    static int[] shortestToChar(String s, char c) {

        int[] distance = new int[s.length()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == c) {
                distance[i] = 0;
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && s.charAt(left) != c) {
                    distance[left] = Math.min(distance[left], Math.abs(left - i));
                    left--;
                }

                while (right < s.length() && s.charAt(right) != c) {
                    distance[right] = Math.min(distance[right], Math.abs(right - i));
                    right++;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        shortestToChar("loveleetcode", 'e');
    }
}
