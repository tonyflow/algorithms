package leetcode.hard.dungeongame;

import java.util.Arrays;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        for (int[] m : memo) Arrays.fill(m, -1);
        return princessWithoutLifePlusMemoization(dungeon, 0, 0, memo);
    }

    private int princessWithoutLifePlusMemoization(int[][] dungeon,
                                                   int i,
                                                   int j,
                                                   int[][] memo) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
            return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;

        if (inBounds(dungeon, i, j)) {
            if (memo[i][j] == -1) {
                int rightwards = princessWithoutLifePlusMemoization(dungeon, i, j + 1,memo);
                int downwards = princessWithoutLifePlusMemoization(dungeon, i + 1, j,memo);


                int minLifeSoFar = Math.min(rightwards, downwards) - dungeon[i][j];
                memo[i][j] = minLifeSoFar <= 0 ? 1 : minLifeSoFar;
            }

            return memo[i][j];
        }

        return Integer.MAX_VALUE;
    }

    private int princessWithoutLife(int[][] dungeon,
                                    int i,
                                    int j) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
            return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;

        if (inBounds(dungeon, i, j)) {
            int rightwards = princessWithoutLife(dungeon, i, j + 1);
            int downwards = princessWithoutLife(dungeon, i + 1, j);


            int minLifeSoFar = Math.min(rightwards, downwards) - dungeon[i][j];
            return minLifeSoFar <= 0 ? 1 : minLifeSoFar;
        }

        return Integer.MAX_VALUE;
    }

    private int princess(int[][] dungeon,
                         int i,
                         int j,
                         int life) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
            if (dungeon[i][j] + life > 0) {
                return 0;
            } else {
                int diff = dungeon[i][j] + life;
                int additional = 1 - diff;
                return additional;
            }

        if (inBounds(dungeon, i, j)) {

            // In order to survive the current block with "life" amount of life
            // If the dungeon's current value plus our life keeps us alive then we do not
            // have to change the amount of life that we have
            if (dungeon[i][j] + life > 0) {
                // int additional = 0;
                return 0 + Math.min(
                        princess(dungeon, i + 1, j, life + dungeon[i][j]),
                        princess(dungeon, i, j + 1, life + dungeon[i][j])
                );
            } else {
                // dungeon[i][j] + life <= 0
                // If the dungeon's current value plus our life DOES NOT keep us alive then we have to extend
                // our life in the minimum fashion. Meaning that it should be enough to keep us alive. Meaning that
                // it should be 1 after visiting this dungeon room, so currentMinLife + dungeon[i][j] = 1 =>
                // currentMinLife = 1 - dungeon[i][j]
                // So our current life should be extended with additional = 1 - diff
                int diff = dungeon[i][j] + life;
                int additional = 1 - diff;
                return additional + Math.min(
                        princess(dungeon, i + 1, j, 1),
                        princess(dungeon, i, j + 1, 1)
                );
            }
        }

        return Integer.MAX_VALUE;
    }

    private boolean inBounds(int[][] dungeon, int i, int j) {
        return i >= 0 && i < dungeon.length && j >= 0 && j < dungeon[0].length;
    }
}
