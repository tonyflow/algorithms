package leetcode.hard;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotRoomCleaner {

    interface Robot {
        /**
         * Returns true is the cell in front is open and robot moves into the cell
         * Returns true is the cell in front is blocked and robot stays in the current cell
         *
         * @return
         */
        boolean move();

        /**
         * Robot will stay at the same cell after calling turnLeft or turnRight
         * Each turn will be 90 degrees
         */
        void turnLeft();

        void turnRight();

        /**
         * Clean the current cell
         */
        void clean();
    }

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return this.i == other.i && this.j == other.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.i, this.j);
        }
    }

    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    void cleanRoom(Robot robot) {

        Set<Pair> cleaned = new HashSet();

        // Since in the beginning the robot is facing upwards
        dfs(robot, 0, 0, 0, cleaned);
    }

    private void dfs(Robot robot,
                     int i,
                     int j,
                     int direction,
                     Set<Pair> cleaned) {
        robot.clean();
        cleaned.add(new Pair(i, j));

        for (int d = 0; d < directions.length; d++) {
            int[] newDirection = directions[(d + direction) % 4];
            Pair candidateForCleaning = new Pair(i + newDirection[0], j + newDirection[1]);
            if (!cleaned.contains(candidateForCleaning) && robot.move()) {
                dfs(robot, candidateForCleaning.i, candidateForCleaning.j, d, cleaned);

                // backtrack
                // we have to return to our original direction
                // we have already moved the robot one cell in the if condition
                // so in order to go back we have to
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
                // Let's say that we were using a 3 y 3 grid, we were at cell (1,1) and we were facing upwards.
                // Then with the move in the if condition we would move to cell (0,1). After we would be done with exploring
                // all possible directions in that cell, we would end up back to (0,1) back this is not our original cell,
                // and by original I mean the cell where the recursion started. So we have to get back to (1,1). In order
                // to do so we have to make a U turn - so turn right twice - then move and then and then make another U
                // turn - turn twice again
            }
            // Now we have to turn right but why? The reason is that the directions array is a helper array for us to
            // identify which cells we have visited but has nothing to do with the API of the robot. So in order for the
            // robot to change directions we would have to use one of its turn API - we can either use right or left.
            robot.turnRight();
        }


    }
}
