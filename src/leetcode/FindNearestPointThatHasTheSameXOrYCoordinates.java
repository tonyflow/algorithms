package leetcode;

public class FindNearestPointThatHasTheSameXOrYCoordinates {

    public int nearestValidPoint(int x,
                                 int y,
                                 int[][] points) {
        int nearest = Integer.MAX_VALUE;
        int nearestIndex = -1;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                // Calculate Manhattan distance
                int diff = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (diff <= nearest) {
                    nearest = diff;
                    nearestIndex = i;
                }
//                else if (diff == nearest && i < nearestIndex) {
//
//                }
//                nearest = Math.min(nearest, diff);
//                nearestInde
            }
        }

        return nearestIndex;
    }
}
