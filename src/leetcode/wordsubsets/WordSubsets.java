package leetcode.wordsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {

    static List<String> naive(String[] a, String[] b) {

        int[][] bCharCounts = new int[b.length][256];
        List<String> result = new ArrayList<>();

        // Find all char frequencies for b
        for (int i = 0; i < b.length; i++) {
            bCharCounts[i] = getCharCount(b[i]);
        }

        // For every word in a check if it's universal against the frequencies created above
        for (int i = 0; i < a.length; i++) {
            boolean isUniversal = true;
            int[] aWordCharCounts = getCharCount(a[i]);
            for (int j = 0; j < bCharCounts.length; j++) {
                // For every character in the string that we actually have a count
                for (int k = 0; k < bCharCounts[j].length; k++) {
                    if (bCharCounts[j][k] != 0 && !(aWordCharCounts[k] >= bCharCounts[j][k])) isUniversal = false;
                }
            }
            if (isUniversal) result.add(a[i]);
        }
        return result;
    }

    static List<String> optimize2(String[] a, String[] b) {
        int[] maxBCharCounts = new int[256];
        Arrays.fill(maxBCharCounts, 0);
        List<String> result = new ArrayList<>();

        // Find max frequencies in b
        for (int i = 0; i < b.length; i++) {
            int[] bCharCounts = getCharCount(b[i]);
            for (int j = 0; j < 256; j++) {
                maxBCharCounts[j] = Math.max(maxBCharCounts[j], bCharCounts[j]);
            }
        }

        for (int i = 0; i < a.length; i++) {
            boolean isUniversal = true;
            int[] aWordCharCounts = getCharCount(a[i]);
            for (int j = 0; j < maxBCharCounts.length; j++) { //  this is constant and equals to 256
                if (maxBCharCounts[j] != 0 && !(aWordCharCounts[j] >= maxBCharCounts[j])) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) result.add(a[i]);
        }

        return result;
    }

    /**
     * Wrong solution -
     * Input : ["amazon","apple","facebook","google","leetcode"] ["lo","eo"]
     * Output: ["google"]
     * Expected: ["google","leetcode"]
     */
    static List<String> optimize1(String[] a, String[] b) {
        List<String> result = new ArrayList<>();
        StringBuilder bStringBuilder = new StringBuilder();
        for (String s : b) {
            bStringBuilder.append(s);
        }
        String bConcatenated = bStringBuilder.toString();
        int[] bCharCounts = getCharCount(bConcatenated);
        for (int i = 0; i < a.length; i++) {
            boolean isUniversal = true;
            int[] aWordCharCounts = getCharCount(a[i]);
            for (int j = 0; j < 256; j++) { //  this is constant and equals to 256
                if (bCharCounts[j] != 0 && !(aWordCharCounts[j] >= bCharCounts[j])) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) result.add(a[i]);
        }

        return result;
    }


    private static int[] getCharCount(String s) {
        int[] counts = new int[256];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        return counts;
    }

    public static void main(String[] args) {
//        System.out.println("Naive " + naive(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
//        System.out.println("Optimize " + optimize1(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
//        System.out.println("Naive " + naive(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"}));
//        System.out.println("Optimize " + optimize1(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"}));
//        System.out.println("Naive " + naive(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"oo", "e"}));
//        System.out.println("Optimize " + optimize1(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"oo", "e"}));

        System.out.println("Optimize " + optimize2(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}));
    }
}
