package leetcode.hard.trappingrainwaterii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    class Cell {
        int i;
        int j;
        int value;

        public Cell(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        int getValue() {
            return this.value;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Cell> queue = new PriorityQueue(Comparator.comparingInt(Cell::getValue));

        // Push border elements
        // Push first row
        for (int j = 0; j < heightMap[0].length; j++) {
            queue.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
        }

        // Rightmost col
        for (int i = 1; i < heightMap.length - 1; i++) {
            queue.offer(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
            visited[i][heightMap[0].length - 1] = true;
        }

        // Bottom row
        for (int j = 0; j < heightMap[0].length; j++) {
            queue.offer(new Cell(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
            visited[heightMap.length - 1][j] = true;
        }

        // Leftmost column
        for (int i = 1; i < heightMap.length - 1; i++) {
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
        }

        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        while (!queue.isEmpty()) {
            Cell polled = queue.poll();
            max = Math.max(max, polled.value);

            for (int d = 0; d < directions.length; d++) {
                int neighborI = polled.i + directions[d][0];
                int neighborJ = polled.j + directions[d][1];
                if (inBounds(heightMap, neighborI, neighborJ) && !visited[neighborI][neighborJ]) {
                    visited[neighborI][neighborJ] = true;

                    // Update res
                    if (heightMap[neighborI][neighborJ] < max)
                        result += max - heightMap[neighborI][neighborJ];

                    queue.offer(new Cell(neighborI, neighborJ, heightMap[neighborI][neighborJ]));
                }
            }
        }

        return result;
    }

    private boolean inBounds(int[][] map, int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }

    public int trapRainWaterWrong(int[][] heightMap) {
        int[][] maxXLeft = new int[heightMap.length][heightMap[0].length];
        int[][] maxXRight = new int[heightMap.length][heightMap[0].length];
        int[][] maxYTop = new int[heightMap.length][heightMap[0].length];
        int[][] maxYBottom = new int[heightMap.length][heightMap[0].length];

        int result = 0;

        // Find max on x axis
        for (int i = 0; i < heightMap.length; i++) {
            // Left to right
            maxXLeft[i][0] = heightMap[i][0];
            for (int j = 1; j < heightMap[0].length; j++) {
                maxXLeft[i][j] = Math.max(maxXLeft[i][j - 1], heightMap[i][j]);
            }

            // Right to left
            maxXRight[i][heightMap[0].length - 1] = heightMap[i][heightMap[0].length - 1];
            for (int j = heightMap[0].length - 2; j >= 0; j--) {
                maxXRight[i][j] = Math.max(maxXRight[i][j + 1], heightMap[i][j]);
            }
        }

        // Find max on y axis
        for (int j = 0; j < heightMap[0].length; j++) {

            // Top to bottom
            maxYTop[0][j] = heightMap[0][j];
            for (int i = 1; i < heightMap.length; i++) {
                maxYTop[i][j] = Math.max(maxYTop[i - 1][j], heightMap[i][j]);
            }

            // Bottom to top
            maxYBottom[heightMap.length - 1][j] = heightMap[heightMap.length - 1][j];
            for (int i = heightMap.length - 2; i >= 0; i--) {
                maxYBottom[i][j] = Math.max(maxYBottom[i + 1][j], heightMap[i][j]);
            }
        }

        // Calculate result
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[0].length - 1; j++) {
                int surroundingMin = Math.min(
                        maxXLeft[i][j],
                        Math.min(
                                maxXRight[i][j],
                                Math.min(
                                        maxYTop[i][j],
                                        maxYBottom[i][j]
                                )
                        )
                );

                int addedVolume = surroundingMin - heightMap[i][j];
                result += addedVolume > 0 ? addedVolume : 0;
            }
        }

        return result;
    }
}
