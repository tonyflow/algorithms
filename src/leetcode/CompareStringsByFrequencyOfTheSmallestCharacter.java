package leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {

    static int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] result = new int[queries.length];

        // Word frequencies
        int[] wordFreqs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordFreqs[i] = freq(words[i]);
        }
        Arrays.sort(wordFreqs);

        // query frequencies
        int[] queryFreqs = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryFreqs[i] = freq(queries[i]);
        }

        for (int i = 0; i < queryFreqs.length; i++) {
            // We want queryFreq < wordFreq
            // wordFreq is ordered
            // We have to find the first entry that does not satisfy this condition
            // We find the count by subtracting this from the length of words array
            int start = 0;
            int end = wordFreqs.length - 1;

            while (start <= end) {
                int middle = (start + end) >>> 1;
                if (wordFreqs[middle] <= queryFreqs[i]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

            result[i] = words.length - start;
        }

        return result;
    }

    static int[] numSmallerByFrequency2(String[] queries, String[] words) {

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int total = 0;
            int queryLexicographicallySmallestCharacterFreq = freq(queries[i]);
            System.out.println("Query freq for " + queries[i] + " is " + queryLexicographicallySmallestCharacterFreq);
            for (String word : words) {
                int wordLexicographicallySmallestCharacterFreq = freq(word);
                System.out.println("Word freq for " + word + " is " + wordLexicographicallySmallestCharacterFreq);
                if (queryLexicographicallySmallestCharacterFreq < wordLexicographicallySmallestCharacterFreq)
                    total++;
            }
            result[i] = total;
            System.out.println("===========================");

        }

        return result;
    }

    static int freq(String s) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int count : counts) {
            if (count > 0) return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] a = {"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"};
        String[] b = {"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"};
//        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
        System.out.println(Arrays.toString(numSmallerByFrequency(a, b)));
    }
}
