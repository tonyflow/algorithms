package leetcode.hard;

import java.util.*;

public class WordLadderII {

    class PathNode {
        String word;
        PathNode parent;

        public PathNode(String word, PathNode parent) {
            this.word = word;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PathNode pathNode = (PathNode) o;
            return Objects.equals(word, pathNode.word) && Objects.equals(parent, pathNode.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, parent);
        }
    }

    public List<List<String>> findLadders(String beginWord,
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
        Set<PathNode> dfsStarts = new HashSet<>();
        for (String word : wordList) {
            if (word.equals(beginWord)) continue;

            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (beginWord.charAt(i) != word.charAt(i)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) dfsStarts.add(new PathNode(word, null));
        }

        if (dfsStarts.size() == 0) return new ArrayList();

        List<List<String>> result = new ArrayList();
        int globalMin = Integer.MAX_VALUE;
        boolean globalFound = false;
        for (PathNode start : dfsStarts) {
            int min = 1;
            Queue<PathNode> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.offer(start);

            boolean found = false;

            List<PathNode> iterationResult = new ArrayList();

            while (!q.isEmpty() && !found) {
                int size = q.size();
                min++;
                for (int i = 0; i < size; i++) {
                    PathNode polled = q.poll();
                    visited.add(polled.word);

                    // We do not want to break since there might be other nodes in the same level through which we
                    // can reach the end word
                    if (polled.word.equals(endWord)) {
                        iterationResult.add(polled);
                        found = true;
                    }

                    for (String neighbor : graph.get(polled.word))
                        if (!visited.contains(neighbor)) q.offer(new PathNode(neighbor, polled));
                }
            }

            // Assemble shortest paths
            if (min == globalMin) {
                // add iteration results to existing results
                List<List<String>> iterationPaths = new ArrayList();
                for (PathNode node : iterationResult) {
                    LinkedList<String> partial = new LinkedList();
                    PathNode current = node;
                    while (current != null) {
                        partial.offerFirst(current.word); // append to the beginning of the list
                        current = current.parent;
                    }
                    partial.offerFirst(beginWord);
                    iterationPaths.add(partial);
                }
                result.addAll(iterationPaths);
            } else if (min < globalMin) {
                // replace results with iteration paths and
                List<List<String>> iterationPaths = new ArrayList();
                for (PathNode node : iterationResult) {
                    LinkedList<String> partial = new LinkedList();
                    PathNode current = node;
                    while (current != null) {
                        partial.offerFirst(current.word); // append to the beginning of the list
                        current = current.parent;
                    }
                    partial.offerFirst(beginWord);
                    iterationPaths.add(partial);
                }
                result = new ArrayList(iterationPaths);

                // update global min
                globalMin = min;
            } else {
                // min > globalMin then do nothing
            }

            if (found) globalFound = true;
        }

        return globalFound ? result : new ArrayList<>();
    }
}
