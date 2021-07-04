package leetcode.coursescheduleii;

import java.util.*;

public class CourseScheduleII {


    // (a,b) -> b -> a
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        // Check if it's cyclic - if it's cyclic we cannot take all courses
        boolean isCyclic = false;

        // Due to backtracking these structures will always be cleared upon every iteration
        Set<Integer> processed = new HashSet<>();
        Set<Integer> processing = new HashSet<>();

        for (int i = 0; i < numCourses && !isCyclic && prerequisites.length > 0; i++) {
            isCyclic = isCyclic || isCyclic(graph, i, processed, processing);
        }

        if (isCyclic) {
            // return empty array
            return new int[0];
        } else {
            // TOPOLOGICAL SORT
            Stack<Integer> sort = new Stack<>();
            processed.clear();
            for (int course = 0; course < numCourses; course++) {
                if (!processed.contains(course)) {
                    sort(graph, course, processed, sort);
                }
            }

            int[] result = new int[sort.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = sort.pop();
            }
            return result;
        }
    }

    private void sort(Map<Integer, List<Integer>> graph,
                      int course,
                      Set<Integer> processed,
                      Stack<Integer> sort) {
        if (processed.contains(course)) return;

        List<Integer> prerequisites = graph.get(course);
        if (prerequisites != null && !prerequisites.isEmpty()) {
            for (Integer prerequisite : prerequisites) {
                sort(graph, prerequisite, processed, sort);
            }
        }
        processed.add(course);
        sort.add(course);
    }

    private boolean isCyclic(Map<Integer, List<Integer>> graph,
                             int course,
                             Set<Integer> processed,
                             Set<Integer> processing) {

        if (processing.contains(course)) return true;

        processing.add(course);
        List<Integer> prerequisites = graph.get(course);
        if (prerequisites != null && !prerequisites.isEmpty()) {
            for (Integer adjacent : prerequisites) {
                if (!processed.contains(adjacent)) {
                    if (isCyclic(graph, adjacent, processed, processing)) return true;
                }
            }
        }

        processing.remove(course);
        processed.add(course);
        return false;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (graph.containsKey(prerequisite[1])) {
                List<Integer> adjacency = graph.get(prerequisite[1]);
                adjacency.add(prerequisite[0]);
                graph.put(prerequisite[1], adjacency);
            } else {
                ArrayList<Integer> adjacency = new ArrayList<>();
                adjacency.add(prerequisite[0]);
                graph.put(prerequisite[1], adjacency);
            }
        }
        return graph;
    }
}
