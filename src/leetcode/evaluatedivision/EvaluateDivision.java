package leetcode.evaluatedivision;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildDirectedWeightedGraph(equations, values);
        double[] solutions = new double[queries.size()];

        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            solutions[i] = findPathCost(graph, start, end, visited, 1);
        }

        return solutions;

    }

    private double findPathCost(Map<String, Map<String, Double>> graph,
                                String a,
                                String b,
                                Set<String> visited,
                                double result) {

        if (a.equals(b)) return result;
        visited.add(a);
        Map<String, Double> adjacent = graph.get(a);
        double factor = Integer.MIN_VALUE;
        for (Map.Entry<String, Double> adjacentToWeight : adjacent.entrySet()) {
            if (!visited.contains(adjacentToWeight.getKey())) {
                factor = Math.max(factor, findPathCost(graph, adjacentToWeight.getKey(), b, visited, adjacentToWeight.getValue()));
            }
        }
        visited.remove(a);
        // If the path does not contain the ending node then this will return MINVALUE which will be cancelled out by the max operation before
        return factor * result;
    }

    private Map<String, Map<String, Double>> buildDirectedWeightedGraph(List<List<String>> equations,
                                                                        double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);

            // Create forwards entry
            if (graph.containsKey(numerator)) {
                graph.get(numerator).put(denominator, values[i]);
            } else {
                Map<String, Double> adjacency = new HashMap<>();
                adjacency.put(denominator, values[i]);
                graph.put(numerator, adjacency);
            }

            // Create backwards entry
            if (graph.containsKey(denominator)) {
                graph.get(denominator).put(numerator, 1 / values[i]);
            } else {
                Map<String, Double> adjacency = new HashMap<>();
                adjacency.put(numerator, 1 / values[i]);
                graph.put(denominator, adjacency);
            }
        }
        return graph;
    }
}
