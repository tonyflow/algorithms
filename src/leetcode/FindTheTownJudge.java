package leetcode;

import java.util.*;

public class FindTheTownJudge {

    static int findJudge(int N, int[][] trust) {

        if (trust.length == 0 && N == 1) {
            return N;
        } else if (trust.length == 0 && N != 1) {
            return -1;
        } else {
            Set<Integer> vertices = new HashSet<>();
            Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
            int answer;
            for (int[] trustFromTo : trust) {
                for (int counterpart : trustFromTo) {
                    vertices.add(counterpart);
                }
                if (adjacencyList.containsKey(trustFromTo[0])) {
                    Set<Integer> updated = adjacencyList.get(trustFromTo[0]);
                    updated.add(trustFromTo[1]);
                    adjacencyList.put(trustFromTo[0], updated);
                } else {
                    Set<Integer> newRelation = new HashSet<>();
                    newRelation.add(trustFromTo[1]);
                    adjacencyList.put(trustFromTo[0], newRelation);
                }
            }

            // After this vertices should only include one element
            vertices.removeAll(adjacencyList.keySet());
            if (vertices.size() != 1) {
                return -1;
            } else {
                answer = new ArrayList<>(vertices).get(0);
                for (Set<Integer> value : adjacencyList.values()) {
                    if (!value.contains(answer)) return -1;
                }

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] trust = {
                {1, 4},
                {1, 3},
                {2, 4},
                {2, 3},
                {4, 3}
        };

        findJudge(34, trust);
    }
}
