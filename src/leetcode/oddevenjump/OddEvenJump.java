package leetcode.oddevenjump;

import java.util.Arrays;

public class OddEvenJump {

    int jumps(int[] r) {

        boolean[] visited = new boolean[r.length];
        int numOfGoodStartingPoints = 0;
        for (int i = 0; i < r.length; i++) {

            int next = i;
            int counter = 1;
            while (next < r.length) {

                // Reached the end of the array so break
                if (next == r.length - 1) {
                    numOfGoodStartingPoints++;
                    break;
                }

                // Odd jump
                if (counter % 2 == 1) {
                    next = processOddJump(r, next, visited);
                }
                // Even jump
                else if (counter % 2 == 0) {
                    next = processEvenJump(r, next, visited);
                } else {
                    throw new RuntimeException("Error");
                }

                if (next == Integer.MAX_VALUE) {
                    // Cannot jump somewhere else so continue with next starting point
                    break;
                }
                counter++;

            }
            Arrays.fill(visited, false);
        }

        return numOfGoodStartingPoints;
    }

    private int processOddJump(int[] r,
                               int basePoint,
                               boolean[] visited) {

        // Mark base point as visited
        visited[basePoint] = true;

        // Find next cell
        // // Find smallest element which has not been visited from the
        // // rest of the array
        int min = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        for (int j = basePoint + 1; j < r.length; j++) {
            if (!visited[j] && r[j] >= r[basePoint]) {
                // Find the smallest in the rest of the array
                if (r[j] < min) {
                    min = r[j];
                    index = j;
                }

                // In case of equality go with the smallest j
                if (r[j] == min && j < index) {
                    index = j;
                }
            }

        }

        if (index != Integer.MAX_VALUE) {
            visited[index] = true;
        }

        return index;
    }

    private int processEvenJump(int[] r,
                                int basePoint,
                                boolean[] visited) {

        // Mark base point as visited
        visited[basePoint] = true;

        // Find next cell
        // // Find largest element which has not been visited from the
        // // rest of the array
        int max = Integer.MIN_VALUE;
        int index = Integer.MAX_VALUE;
        for (int j = basePoint + 1; j < r.length; j++) {

            if (!visited[j] && r[j] <= r[basePoint]) {
                // Find the largest in the rest of the array
                if (r[j] > max) {
                    max = r[j];
                    index = j;
                }

                // In case of equality go with the smallest j
                if (r[j] == max && j < index) {
                    index = j;
                }
            }
        }

        if (index != Integer.MAX_VALUE) {
            visited[index] = true;
        }

        return index;

    }
}
