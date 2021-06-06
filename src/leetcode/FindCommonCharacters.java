package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindCommonCharacters {

    /**
     * We can avoid the use of the intersection of hashsets. The following rationale can help as do that:
     * 1.
     */
    static List<String> makeItBetter(String[] A) {

        int[] minCountsGlobal = new int[26];
        Arrays.fill(minCountsGlobal, Integer.MAX_VALUE);
        ArrayList<String> result = new ArrayList<>();

        for (String s : A) {
            int[] counts = new int[26];
            Arrays.fill(counts, 0);
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minCountsGlobal[i] = Math.min(minCountsGlobal[i], counts[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minCountsGlobal[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minCountsGlobal[i]--;
            }
        }

        return result;
    }

    static List<String> commonChars(String[] A) {

        HashSet<Character> intersection = new HashSet<Character>();
        int[] countsGlobal = new int[26];
        Arrays.fill(countsGlobal, Integer.MAX_VALUE);
        for (char i = 'a'; i <= 'z'; i++) {
            intersection.add(i);

        }


        for (String s : A) {
            HashSet<Character> uniqueChars = new HashSet<>();
            int[] counts = new int[26];
            Arrays.fill(counts, 0);
            for (char c : s.toCharArray()) {
                uniqueChars.add(c);
                counts[c - 'a']++;
            }

            intersection.retainAll(uniqueChars);
            for (Character character : intersection) {
                countsGlobal[character - 'a'] = Math.min(countsGlobal[character - 'a'], counts[character - 'a']);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (Character character : intersection) {
            for (int i = 0; i < countsGlobal[character - 'a']; i++) {
                result.add(Character.toString(character));
            }
        }


        return result;
    }

    public static void main(String[] args) {
//        commonChars(new String[]{"bella", "label", "roller"});
        makeItBetter(new String[]{"bella", "label", "roller"});
    }
}
