package leetcode.canvisitallrooms;

import java.util.Arrays;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        // [[1],[2],[3]]
        // [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3),Arrays.asList());
        List<List<Integer>> unescapable = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0));
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        System.out.println(canVisitAllRooms.check(rooms));
        System.out.println(canVisitAllRooms.check(unescapable));
    }
}
