package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfIslandsII {

    /**
     * A 2d grid map of m rows and n columns is initially filled with water.
     * We may perform an addLand operation which turns the water at position (row, col) into a land.
     * Given a list of positions to operate, count the number of islands after each addLand operation.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Two optimization which can be achieved here:
     * - Path compaction
     * - Union by rank
     */

    Map<String, String> uf = new HashMap();

    public List<Integer> numIslands2(int m,
                                     int n,
                                     int[][] positions) {
        List<Integer> result = new ArrayList();
        int[][] grid = new int[m][n];

        int[][] neighbors = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];
            addLand(grid, row, col);

            for (int[] neighbor : neighbors) {
                int neighborRow = neighbor[0] + row;
                int neighborCol = neighbor[1] + col;
                if (grid[neighborRow][neighborCol] == 1) {
                    union(row, col, neighborRow, neighborCol);
                }
            }

            int islands = 0;
            for (Map.Entry<String, String> entry : uf.entrySet()) {
                if (entry.getKey().equals(entry.getValue())) islands++;
            }
            result.add(islands);
        }

        return result;
    }

    private void union(int aRow,
                       int aCol,
                       int bRow,
                       int bCol) {
        String representativeA = find(aRow + "_" + aCol);
        String representativeB = find(bRow + "_" + bCol);
        uf.put(representativeA, representativeB);
    }

    private String find(String representative) {
        if (uf.get(representative) != null && !uf.get(representative).equals(representative)) {
            return find(uf.get(representative));
        }
        return representative;
    }

    private void addLand(int[][] grid, int row, int col) {
        grid[row][col] = 1;
    }
}
