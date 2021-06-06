package leetcode.oddevenjump;

import java.util.*;

/**
 * This is a dead end solution
 */
public class OddEvenJumpDeadEnd {

    private TreeMap<Integer, LinkedList<Integer>> createMap(int[] r) {
        // Create TreeMap
        TreeMap<Integer, LinkedList<Integer>> help = new TreeMap<>();
        for (int i = 0; i < r.length; i++) {
            if (help.containsKey(r[i])) {
                LinkedList<Integer> update = help.get(r[i]);
                update.add(i);
                help.put(r[i], update);
            } else {
                LinkedList<Integer> index = new LinkedList<>();
                index.add(i);
                help.put(r[i], index);
            }

        }

        return help;
    }

    int jumps(int[] r) {

        boolean[] visited = new boolean[r.length];
        int numOfGoodStartingPoints = 0;

        // Create TreeMap
        TreeMap<Integer, LinkedList<Integer>> help = createMap(r);

        for (int i = 0; i < r.length; i++) {

            Integer next = i;
            int counter = 1;
            while (next < r.length) {

                // Reached the end of the array so break
                if (next == r.length - 1) {
                    numOfGoodStartingPoints++;
                    break;
                }

                if (!help.get(r[next]).isEmpty()) {
                    LinkedList<Integer> update = help.get(r[next]);
                    update.removeFirst();
                    if (update.isEmpty()) {
                        help.remove(r[next]);
                    } else {
                        help.put(r[next], update);
                    }
                } else {
                    help.remove(r[next]);
                }

                // Odd jump
                if (counter % 2 == 1) {
                    Map.Entry<Integer, LinkedList<Integer>> nextEntry = processOddJump(r, visited, help, next);

                    if (nextEntry == null) {
                        break;
                    } else {
                        next = nextEntry.getValue().peek();
                    }
                }
                // Even jump
                else if (counter % 2 == 0) {
                    Map.Entry<Integer, LinkedList<Integer>> nextEntry = processEvenJump(r, visited, help, next);

                    if (nextEntry == null) {
                        break;
                    } else {
                        next = nextEntry.getValue().peek();
                    }
                } else {
                    throw new RuntimeException("Error");
                }

                if (next == null) {
                    // Cannot jump somewhere else so continue with next starting point
                    break;
                }
                counter++;

            }
            Arrays.fill(visited, false);
            help = createMap(r);
        }

        return numOfGoodStartingPoints;
    }

    private Map.Entry<Integer, LinkedList<Integer>> processEvenJump(int[] r,
                                                                    boolean[] visited,
                                                                    TreeMap<Integer, LinkedList<Integer>> help,
                                                                    int basePoint) {
        // Mark base point as visited
        visited[basePoint] = true;

        return help.floorEntry(r[basePoint]);
    }

    private Map.Entry<Integer, LinkedList<Integer>> processOddJump(int[] r,
                                                                   boolean[] visited,
                                                                   TreeMap<Integer, LinkedList<Integer>> help,
                                                                   int basePoint) {
        // Mark base point as visited
        visited[basePoint] = true;

        return help.ceilingEntry(r[basePoint]);
    }
}
