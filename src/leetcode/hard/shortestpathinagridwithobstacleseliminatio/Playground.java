package leetcode.hard.shortestpathinagridwithobstacleseliminatio;

import java.util.List;

public class Playground {

    public static void main(String[] args) {
        ShortestPathInAGridWithObstaclesElimination shortestPathInAGridWithObstaclesElimination = new ShortestPathInAGridWithObstaclesElimination();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0}
        };

        int[][] smaller = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
//        System.out.println(shortestPathInAGridWithObstaclesElimination.shortestPath(grid,27));
//        System.out.println(shortestPathInAGridWithObstaclesElimination.shortestPath(smaller,1));
//        List<ShortestPathInAGridWithObstaclesElimination.Coordinate> coordinates = shortestPathInAGridWithObstaclesElimination.actualShortestPath(grid, 27);
        List<ShortestPathInAGridWithObstaclesElimination.Coordinate> coordinates = shortestPathInAGridWithObstaclesElimination.actualShortestPath(smaller, 1);
        for (ShortestPathInAGridWithObstaclesElimination.Coordinate coordinate : coordinates) {
            System.out.println("r=" + coordinate.r + " ,c=" + coordinate.c);
        }
    }
}
