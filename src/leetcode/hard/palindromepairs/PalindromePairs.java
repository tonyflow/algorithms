package leetcode.hard.palindromepairs;

import java.util.*;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordsToIndex = new HashMap();
        Set<List<Integer>> result = new HashSet();

        for (int i = 0; i < words.length; i++)
            wordsToIndex.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            char[] r = words[i].toCharArray();

            // compare with empty string
            if (isPalindrome(words[i]) &&
                    wordsToIndex.containsKey("") &&
                    wordsToIndex.get("") != i) {
                result.add(Arrays.asList(i, wordsToIndex.get("")));
                result.add(Arrays.asList(wordsToIndex.get(""), i));
            }

            // append to the end in a forwards order
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < r.length; j++) {
                String candidate = reverse(builder.append(r[j]).toString());
                if (isPalindrome(words[i] + candidate) &&
                        wordsToIndex.containsKey(candidate) &&
                        wordsToIndex.get(candidate) != i)
                    result.add(Arrays.asList(i, wordsToIndex.get(candidate)));
            }

            // append to the start in a backwards order
            // For word sssll we will try {l-sssll,ll-sssll,lls-sssll,llss-sssll,llsss-sssll}
            // candidate = {l,ll,sll}
            builder = new StringBuilder();
            for (int j = r.length-1; j >= 0; j--) {
                String candidate = builder.append(r[j]).toString();
                if (isPalindrome(candidate + words[i]) &&
                        wordsToIndex.containsKey(candidate) &&
                        wordsToIndex.get(candidate) != i)
                    result.add(Arrays.asList(wordsToIndex.get(candidate), i));
            }

        }
        return new ArrayList(result);
    }

    private String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }

    public List<List<Integer>> tle(String[] words) {

        Set<List<Integer>> result = new HashSet();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (isPalindrome(words[i] + words[j])) result.add(Arrays.asList(i, j));
                if (isPalindrome(words[j] + words[i])) result.add(Arrays.asList(j, i));
            }
        }

        return new ArrayList(result);
    }

    private boolean isPalindrome(String a) {
        int start = 0;
        int end = a.length() - 1;
        while (start < end) {
            if (a.charAt(start) != a.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
