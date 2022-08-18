package leetcode.hard.MaxPointsInALine;

import java.util.*;

public class MaxPointsInALine {

    public int maxPoints(int[][] points){
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Set<int[]>> keeperNotParallelToAnyAxis = new HashMap();
            Map<Double, Set<int[]>> keeperParallelToXAxis = new HashMap();
            Map<Double, Set<int[]>> keeperParallelToYAxis = new HashMap();

            for (int j = i + 1; j < points.length; j++) {
                if (points[j][1] == points[i][1]) {
                    Set<int[]> update;
                    if (keeperParallelToXAxis.containsKey((double) points[j][1])) {
                        update = keeperParallelToXAxis.get((double) points[j][1]);
                    } else {
                        update = new HashSet();
                    }
                    update.add(points[i]);
                    update.add(points[j]);
                    keeperParallelToXAxis.put((double) points[j][1], update);
                } else if (points[j][0] == points[i][0]) {
                    Set<int[]> update;
                    if (keeperParallelToYAxis.containsKey((double) points[j][0])) {
                        update = keeperParallelToYAxis.get((double) points[j][0]);
                    } else {
                        update = new HashSet();
                    }
                    update.add(points[i]);
                    update.add(points[j]);
                    keeperParallelToYAxis.put((double) points[j][0], update);
                } else {
                    double gradient = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);

                    Set<int[]> update;
                    if (keeperNotParallelToAnyAxis.containsKey(gradient)) {
                        update = keeperNotParallelToAnyAxis.get(gradient);
                    } else {
                        update = new HashSet();
                    }
                    update.add(points[i]);
                    update.add(points[j]);
                    keeperNotParallelToAnyAxis.put(gradient, update);
                }
            }

            System.out.println("For point " + Arrays.toString(points[i]));
            System.out.println("Parallel to X");
            for (Map.Entry<Double, Set<int[]>> candidate : keeperParallelToXAxis.entrySet()) {
                max = Math.max(max, candidate.getValue().size());
                System.out.println("Points for gradient "+candidate.getKey());
                for (int[] p : candidate.getValue())
                    System.out.println(Arrays.toString(p));
                System.out.println("===========================");
            }
            System.out.println("Parallel to Y");
            for (Map.Entry<Double, Set<int[]>> candidate : keeperParallelToYAxis.entrySet()) {
                max = Math.max(max, candidate.getValue().size());
                System.out.println("Points for gradient "+candidate.getKey());
                for (int[] p : candidate.getValue())
                    System.out.println(Arrays.toString(p));
                System.out.println("===========================");
            }
            System.out.println("Parallel to nothing");
            for (Map.Entry<Double, Set<int[]>> candidate : keeperNotParallelToAnyAxis.entrySet()) {
                max = Math.max(max, candidate.getValue().size());
                System.out.println("Points for gradient "+candidate.getKey());
                for (int[] p : candidate.getValue())
                    System.out.println(Arrays.toString(p));
                System.out.println("===========================");
            }

            System.out.println("******************************************");
        }

        return max;
    }

    private void print(Collection<Set<int[]>> c) {
        for (Set<int[]> r : c)
            for (int[] foo : r)
                System.out.println(Arrays.toString(foo));
    }

    public int on3(int[][] points) {

        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int iterationMax = 2;
                if (points[j][1] == points[i][1]) {
                    for (int k = j + 1; k < points.length; k++) {
                        if (points[k][1] == points[j][1]) iterationMax++;
                    }
                } else if (points[j][0] == points[i][0]) {
                    for (int k = j + 1; k < points.length; k++) {
                        if (points[k][0] == points[j][0]) iterationMax++;
                    }
                } else {
                    double referenceGradient = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                    for (int k = j + 1; k < points.length; k++) {
                        double gradient = (double) (points[j][1] - points[k][1]) / (double) (points[j][0] - points[k][0]);
                        if (gradient == referenceGradient)
                            iterationMax++;
                    }
                }
                max = Math.max(max, iterationMax);
            }
        }
        return max;
    }
}
