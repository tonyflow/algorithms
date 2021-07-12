package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionLabels {

    static class Pair {
        int first;
        int last;

        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    static public List<Integer> partitionLabels(String s) {
        Map<Character, Pair> occurrences = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            occurrences.put(i, new Pair(s.indexOf(i), s.lastIndexOf(i)));
        }
        for (Map.Entry<Character, Pair> characterPairEntry : occurrences.entrySet()) {
            if (characterPairEntry.getValue().last != -1 || characterPairEntry.getValue().first != -1)
                System.out.println("For character " + characterPairEntry.getKey() + " first occurence is " + characterPairEntry.getValue().first + " and last index is " + characterPairEntry.getValue().last);
        }

        List<Pair> sortedIntervals = occurrences.values().stream()
                .filter(pair -> pair.first != -1 || pair.last != -1)
                .sorted(Comparator.comparingInt(pair -> pair.first)).collect(Collectors.toList());

        // Merge intervals
        int referenceStart = sortedIntervals.get(0).first;
        int referenceEnd = sortedIntervals.get(0).last;
        List<Pair> merged = new ArrayList<>();

        for (Pair interval : sortedIntervals) {
            if (interval.first <= referenceEnd) {
                referenceEnd = Math.max(interval.last, referenceEnd);
            } else {
                merged.add(new Pair(referenceStart, referenceEnd));
                referenceStart = interval.first;
                referenceEnd = interval.last;
            }
        }

        merged.add(new Pair(referenceStart, referenceEnd));

        for (Pair mergedPair : merged) {
            result.add(mergedPair.last - mergedPair.first + 1);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
