package leetcode;

import java.util.*;

public class CourseSchedule {

    static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) return true;

        Map<Integer, Set<Integer>> adjacency = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (adjacency.containsKey(prerequisite[0])) {
                Set<Integer> updated = adjacency.get(prerequisite[0]);
                updated.add(prerequisite[1]);
                adjacency.put(prerequisite[0], updated);
            } else {
                Set<Integer> updated = new HashSet<>();
                updated.add(prerequisite[1]);
                adjacency.put(prerequisite[0], updated);
            }
        }

        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> black = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, adjacency,black, visited)) return false;
//            if (!bfs(i, adjacency, visited)) return false;
        }
        return true;
    }

    private static boolean isCyclic(Integer course,
                                    Map<Integer, Set<Integer>> adjacency,
                                    HashSet<Integer> black,
                                    boolean[] visited) {

        if (visited[course]) return true;

        visited[course] = true;
        Set<Integer> requirements = adjacency.get(course);
        if (requirements != null && !requirements.isEmpty()) {
            for (Integer requirement : requirements) {
                if (!black.contains(requirement) && isCyclic(requirement, adjacency, black, visited)) return true;
            }
        }

        black.add(course);
        visited[course] = false;

        return false;
    }

    private static boolean bfs(Integer course,
                               Map<Integer, Set<Integer>> adjacency,
                               boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(course);

        while (!queue.isEmpty()) {
            Integer nextNode = queue.poll();

            // cycle detected
            if (visited[nextNode])
                return false;

            if (adjacency.get(nextNode) != null && !adjacency.get(nextNode).isEmpty())
                queue.addAll(adjacency.get(nextNode));

            visited[nextNode] = true;
        }

        // Reset visited array
        Arrays.fill(visited, false);

        return true;


    }


    public static void main(String[] args) {
//        System.out.println(canFinish(2, new int[][]{{1, 0}}));
//        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 0}, {0, 2}}));
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }
}
