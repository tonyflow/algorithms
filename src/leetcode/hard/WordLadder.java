package leetcode.hard;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        // Create graph
        Map<String, Set<String>> graph = new HashMap<>();

        for (String reference : wordList) {
            Set<String> adjacent = new HashSet<>();
            for (String word : wordList) {
                if (word.equals(reference)) continue;

                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (reference.charAt(i) != word.charAt(i)) diff++;
                    if (diff > 1) break;
                }
                if (diff == 1) adjacent.add(word);
            }
            graph.put(reference, adjacent);
        }


        // Find words closest to beginWord
        Set<String> dfsStarts = new HashSet<>();
        for (String word : wordList) {
            if (word.equals(beginWord)) continue;

            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (beginWord.charAt(i) != word.charAt(i)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) dfsStarts.add(word);
        }

        if (dfsStarts.size() == 0) return 0;

        System.out.println(dfsStarts);

        int globalMin = Integer.MAX_VALUE;
        boolean globalFound = false;
        for (String start : dfsStarts) {
            int min = 1;
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.offer(start);

            boolean found = false;

            while (!q.isEmpty() && !found) {
                int size = q.size();
                min++;
                for (int i = 0; i < size; i++) {
                    String polled = q.poll();
                    visited.add(polled);
                    if (polled.equals(endWord)) {
                        found = true;
                        break;
                    }

                    for (String neighbor : graph.get(polled))
                        if (!visited.contains(neighbor)) q.offer(neighbor);
                }
            }
            globalMin = Math.min(globalMin, min);
            if(found) globalFound = true;
        }

        return globalFound ? globalMin : 0;
    }
}
