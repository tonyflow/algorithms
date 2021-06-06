package backtracking;

import java.util.Arrays;

public class RatInAMazePuzzle {

    int[][] path;

    void escape(int[][] maze) {

        path = new int[maze.length][maze[0].length];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], -1);
        }

        if (!doEscape(maze, 0, 0, 0)) {
            System.out.println("Cannot escape from the maze");
        }
    }

    private boolean doEscape(int[][] maze, int row, int col, int index) {

        path[row][col] = index;

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            print();
            return true;
        }

        // Up
        if (isSafe(maze, row - 1, col) && doEscape(maze, row - 1, col, index + 1)) return true;

        // Right
        if (isSafe(maze, row, col + 1) && doEscape(maze, row, col + 1, index + 1)) return true;

        // Down
        if (isSafe(maze, row + 1, col) && doEscape(maze, row + 1, col, index + 1)) return true;

        // Left
        if (isSafe(maze, row, col - 1) && doEscape(maze, row, col - 1, index + 1)) return true;

        path[row][col] = -1;

        return false;
    }

    private boolean isSafe(int[][] maze,
                           int row,
                           int col) {

        if (row >= 0 && row < path.length && col >= 0 && col < path[0].length && maze[row][col] != 0 && path[row][col] == -1)
            return true;
        return false;
    }

    private void print() {
        System.out.println("Solution: ");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.printf("%2d ", path[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("===================");
    }
}
