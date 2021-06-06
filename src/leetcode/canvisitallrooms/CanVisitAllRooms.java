package leetcode.canvisitallrooms;

import java.util.List;

/**
 * Connectivity in a directed graph
 * https://leetcode.com/problems/keys-and-rooms/
 *
 */
public class CanVisitAllRooms {


    boolean check(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    void dfs(List<List<Integer>> rooms,
             int index,
             boolean[] visited) {
        visited[index] = true;
        List<Integer> neighbours = rooms.get(index);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                dfs(rooms, neighbour, visited);
            }
        }
    }

}
