package leetcode.hard.shortestpathinagridwithobstacleseliminatio;

import java.util.*;

public class ShortestPathInAGridWithObstaclesElimination {

    /**
     * This will find the LENGTH of the shortest path
     */
    public int shortestPath(int[][] grid, int k) {

        int[][] directions = {
                {-1, 0}, //up
                {0, 1}, //right
                {1, 0}, // down
                {0, -1} //left
        };
        Queue<Coordinate> q = new LinkedList<>();
        Coordinate source = new Coordinate(0, 0, 0, null);
        q.offer(source);
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1]; // k + 1 since dynamites must be between 1 and k not 0 and k-1
        int path = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Coordinate polled = q.poll();

                if (polled.r == grid.length - 1 && polled.c == grid[0].length - 1)
                    return path;

                for (int j = 0; j < directions.length; j++) {
                    // For every different direction recompute the dimensions of the problem
                    int nextR = polled.r + directions[j][0];
                    int nextC = polled.c + directions[j][1];
                    int nextK = polled.dynamites;

                    if (inBounds(nextR, nextC, grid)) {
                        if (grid[nextR][nextC] == 1) nextK++;

                        if (nextK <= k && !visited[nextR][nextC][nextK]) {
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new Coordinate(nextR, nextC, nextK, polled));
                        }
                    }
                }
            }
            path++;

        }
        return -1;
    }


    class Coordinate {
        int r;
        int c;
        int dynamites;
        Coordinate parent;

        public Coordinate(int r,
                          int c,
                          int dynamites,
                          Coordinate parent) {
            this.r = r;
            this.c = c;
            this.dynamites = dynamites;
            this.parent = parent;
        }
    }

    /**
     * This will return coordinates which create the path
     */
    public List<Coordinate> actualShortestPath(int[][] grid,
                                               int k) {

        int[][] directions = {
                {-1, 0}, //up
                {0, 1}, //right
                {1, 0}, // down
                {0, -1} //left
        };
        Queue<Coordinate> q = new LinkedList<>();
        Coordinate source = new Coordinate(0, 0, 0, null);
        q.offer(source);
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1]; // k + 1 since dynamites must be between 1 and k not 0 and k-1
        boolean reachedDestination = false;
        Coordinate destination = null;

        while (!q.isEmpty() && !reachedDestination) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate polled = q.poll();

                // Condition for reaching the lower right side of the array
                if (polled.r == grid.length - 1 && polled.c == grid[0].length - 1) {
                    reachedDestination = true;
                    destination = polled;
                    break;
                }

                for (int j = 0; j < directions.length; j++) {
                    // For every different direction recompute the dimensions of the problem
                    int nextR = polled.r + directions[j][0];
                    int nextC = polled.c + directions[j][1];
                    int nextK = polled.dynamites;

                    if (inBounds(nextR, nextC, grid)) {
                        if (grid[nextR][nextC] == 1) nextK++;

                        if (nextK <= k && !visited[nextR][nextC][nextK]) {
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new Coordinate(nextR, nextC, nextK, polled));
                        }
                    }
                }
            }
        }

        List<Coordinate> path = new ArrayList<>();

        while (destination != null) {
            path.add(destination);
            destination = destination.parent;
        }

        Collections.reverse(path);

        return path;
    }

    private boolean inBounds(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
