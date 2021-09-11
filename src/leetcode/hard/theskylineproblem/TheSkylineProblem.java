package leetcode.hard.theskylineproblem;

import java.util.*;

/**
 * This questions can also be asked as merging of two-dimensional intervals
 */
public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        // Initialize structures
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Coordinate[] coordinates = new Coordinate[buildings.length * 2];

        // Build coordinates list
        for (int i = 0; i < buildings.length; i++) {
            coordinates[2 * i] = new Coordinate(buildings[i][0], buildings[i][2], true);
            coordinates[2 * i + 1] = new Coordinate(buildings[i][1], buildings[i][2], false);
        }

//        System.out.println(Arrays.toString(coordinates));

        Arrays.sort(coordinates);

        queue.offer(0);
        int previousMax = 0;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.isStart) {
                queue.offer(coordinate.y);
                if (queue.peek() > previousMax) {
                    // We add this exact coordinate in the queue
                    result.add(Arrays.asList(coordinate.x, coordinate.y));
                    previousMax = coordinate.y;
                }
            } else {
                queue.remove(coordinate.y);
                // Did the max change by removing this height?
                if (previousMax != queue.peek()) {
                    // If it did
                    result.add(Arrays.asList(coordinate.x, queue.peek()));
                    // Update previous max
                    previousMax = queue.peek();
                }
                // If it did not this means that the current building is overshadowed by the building which currently
                // holds the max value in the priority queue
            }
        }
        return result;
    }


    public List<List<Integer>> getSkylineUseOnlyCriticalPoints(int[][] buildings) {

        Stack<List<Integer>> stack = new Stack<>();

        // Build a height map

        // 1. Find the maximum right x in the buildings array
        int maxRightX = 0;
        int minLeftX = Integer.MAX_VALUE;
        for (int[] building : buildings) {
            maxRightX = Math.max(maxRightX, building[1]);
            minLeftX = Math.min(minLeftX, building[0]);
        }


        // 2. Create array holding the max height per x coordinate
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();

        // 3. Initialize the map
        for (int[] building : buildings) {
            heightMap.put(building[0], 0);
            heightMap.put(building[1], 0);
        }


        // 4. Populate the map
        for (int[] building : buildings) {
            int currentLeftEnd = building[0];
            int currentRightEnd = building[1];
            int currentHeight = building[2];
            for (int x = currentLeftEnd; x <= currentRightEnd; x++) {
                if (heightMap.containsKey(x)) {
                    heightMap.put(x, Math.max(heightMap.get(x), currentHeight));
                }
            }

        }

        System.out.println(heightMap);

        // Create the contour map
//        for (int[] building : buildings) {
//            int buildingXLeft = building[0];
//            int buildingXRight = building[1];
//            int buildingHeight = building[2];
//            for (Map.Entry<Integer, Integer> e : heightMap.entrySet()) {
//                Integer criticalX = e.getKey();
//                Integer criticalY = e.getValue();
//                if (criticalX >= buildingXLeft && criticalX < buildingXRight) {
//                    Map.Entry<Integer, Integer> previousHeightMapEntry = heightMap.lowerEntry(criticalX);
//                    List<Integer> partial = new ArrayList<>();
//                    partial.add(criticalX);
//                    if (previousHeightMapEntry != null)
//                        partial.add(Math.max(previousHeightMapEntry.getValue(), buildingHeight));
//                    else partial.add(criticalY);
//                    stack.push(partial);
//                }
//            }
//        }
//        for (Map.Entry<Integer, Integer> e : heightMap.entrySet()) {
//
//            Integer currentX = e.getKey();
//            Integer currentY = e.getValue(); // or height
//            if (currentX < minLeftX) continue;
//            if (stack.isEmpty()) {
//                List<Integer> partial = new ArrayList<>();
//                partial.add(currentX);
//                partial.add(currentY);
//                stack.push(partial);
//            } else {
//                // previous height is smaller
//                if (stack.peek().get(1) < currentY) {
//                    List<Integer> partial = new ArrayList<>();
//                    partial.add(currentX);
//                    partial.add(currentY);
//                    stack.push(partial);
//                } else if (stack.peek().get(1) == currentY) {
//                    continue;
//                } else {
//                    // previous height is larger
//                    List<Integer> partial = new ArrayList<>();
//                    Map.Entry<Integer, Integer> previousHeightMapEntry = heightMap.lowerEntry(currentX);
//                    partial.add(previousHeightMapEntry.getKey());
//                    partial.add(currentY);
//                    stack.push(partial);
//                }
//            }
//        }

        List<Integer> termination = new ArrayList<>();
        termination.add(maxRightX);
        termination.add(0);
        stack.add(termination);

        return new ArrayList<>(stack);
    }


    /**
     * Brute force solution using a hash map for a heightmap
     */
    public List<List<Integer>> getSkylineUseMapInsteadOfAnArray(int[][] buildings) {

        Stack<List<Integer>> stack = new Stack<>();

        // Build a height map

        // 1. Find the maximum right x in the buildings array
        int maxRightX = 0;
        int minLeftX = Integer.MAX_VALUE;
        for (int[] building : buildings) {
            maxRightX = Math.max(maxRightX, building[1]);
            minLeftX = Math.min(minLeftX, building[0]);
        }


        // 2. Create array holding the max height per x coordinate
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();

        // 3. Initialize the map
        for (int x = 1; x <= maxRightX; x++) {
            heightMap.put(x, 0);
        }


        // 4. Populate the map
        for (int[] building : buildings) {
            int currentLeftEnd = building[0];
            int currentRightEnd = building[1];
            int currentHeight = building[2];
            for (int x = currentLeftEnd; x <= currentRightEnd; x++) {
                heightMap.put(x, Math.max(heightMap.getOrDefault(x, 0), currentHeight));
            }
        }

        // Create the contour map
        for (Map.Entry<Integer, Integer> e : heightMap.entrySet()) {

            Integer currentX = e.getKey();
            Integer currentY = e.getValue(); // or height
            if (currentX < minLeftX) continue;
            if (stack.isEmpty()) {
                List<Integer> partial = new ArrayList<>();
                partial.add(currentX);
                partial.add(currentY);
                stack.push(partial);
            } else {
                // previous height is smaller
                if (stack.peek().get(1) < currentY) {
                    List<Integer> partial = new ArrayList<>();
                    partial.add(currentX);
                    partial.add(currentY);
                    stack.push(partial);
                } else if (stack.peek().get(1) == currentY) {
                    continue;
                } else {
                    // previous height is larger
                    List<Integer> partial = new ArrayList<>();
                    Map.Entry<Integer, Integer> previousHeightMapEntry = heightMap.lowerEntry(currentX);
                    partial.add(previousHeightMapEntry.getKey());
                    partial.add(currentY);
                    stack.push(partial);
                }
            }
        }

        List<Integer> termination = new ArrayList<>();
        termination.add(maxRightX);
        termination.add(0);
        stack.add(termination);

        return new ArrayList<>(stack);
    }


    /**
     * Brute force solution using an array for a heightmap
     */
    public List<List<Integer>> getSkylineRuntimeErrorOnINT_MAXHeights(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();

        // Build a height map

        // 1. Find the maximum right x in the buildings array
        int maxRightX = 0;
        int minLeftX = Integer.MAX_VALUE;
        for (int[] building : buildings) {
            maxRightX = Math.max(maxRightX, building[1]);
            minLeftX = Math.min(minLeftX, building[0]);
        }

        // 2. Create array holding the max height per x coordinate
        int[] heightMap = new int[maxRightX + 1];
        Arrays.fill(heightMap, 0);

        // 3. Populate the map: Each cell of the map contains the max height on every x coordinate
        for (int[] building : buildings)
            for (int x = building[0]; x <= building[1]; x++)
                heightMap[x] = Math.max(heightMap[x], building[2]);

        // Create the contour map
        for (int i = 1; i <= maxRightX; i++) {
            if (i < minLeftX) continue;
            if (result.isEmpty() || heightMap[i - 1] != heightMap[i]) {
                List<Integer> partial = new ArrayList<>();
                // previous height is smaller
                if (heightMap[i - 1] < heightMap[i])
                    partial.add(i);
                else
                    // previous height is bigger
                    partial.add(i - 1);

                partial.add(heightMap[i]);
                result.add(partial);
            }
        }

        List<Integer> termination = new ArrayList<>();
        termination.add(maxRightX);
        termination.add(0);
        result.add(termination);

        return result;
    }
}
