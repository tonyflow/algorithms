package leetcode.hard.substringwithconcatenationofallwords;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        // Check early fail
        int totalChars = 0;
        for (String word : words)
            totalChars += word.length();
        if (totalChars >= s.length()) return new ArrayList();

        List<Integer> result = new ArrayList();

        Map<String, Integer> occurrences = new HashMap();
        for (String word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();

        for (int i = 0; i < s.length() - wordLength; i++) {
            int j = 0;
            Map<String, Integer> seen = new HashMap();

            while (j < words.length) {
                String nextWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (occurrences.containsKey(nextWord)) {
                    seen.put(nextWord, seen.getOrDefault(nextWord, 0) + 1);
                    if (seen.get(nextWord) > occurrences.get(nextWord)) {
                        break;
                    } else {
                        j++;
                    }
                } else {
                    break;
                }
            }
            if (j == words.length) result.add(i);
        }

        return result;
    }

    public List<Integer> tle(String s, String[] words) {
        // Check early fail
        int totalChars = 0;
        for (String word : words)
            totalChars += word.length();
        if (totalChars >= s.length()) return new ArrayList();

        Set<String> permutations = new HashSet();
        Set<Integer> visited = new HashSet();
        findAllPermutations(words, new StringBuilder(), permutations, visited);

        List<Integer> result = new ArrayList();
        for (String permutation : permutations) {
//            for(int lastIndex=0;lastIndex!=-1;lastIndex = s.indexOf(permutation, lastIndex)+permutation.length()){
//                result.add(lastIndex);
//            }
            int lastIndex = 0;
            while (lastIndex != -1) {
                lastIndex = s.indexOf(permutation, lastIndex);
                if (lastIndex != -1) {
                    result.add(lastIndex);
                    lastIndex += permutation.length();
                }
            }
        }

        return result;
    }


    private void findAllPermutations(String[] words,
                                     StringBuilder builder,
                                     Set<String> permutations,
                                     Set<Integer> visited) {
        if (visited.size() == words.length)
            permutations.add(builder.toString());
        else {
            for (int i = 0; i < words.length; i++) {
                if (!visited.contains(i)) {
                    builder.append(words[i]);
                    visited.add(i);
                    findAllPermutations(words, builder, permutations, visited);
                    visited.remove(i);
                    builder.delete(builder.length() - words[i].length(), builder.length());
                }
            }
        }
    }
}
