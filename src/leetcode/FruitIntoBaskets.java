package leetcode;

import java.util.TreeMap;


/**
 * Longest contiguous sub-array of only two integers
 */
public class FruitIntoBaskets {

    static int betterSpaceComplexity(int[] tree) {
        int lastFruit = -1;
        int secondToLastFruit = -1;
        int lastFruitCount = 0;
        int currentMax = 0;
        int max = 0;

        for (int fruit : tree) {

            // Evaluate current max
            if (fruit == lastFruit || fruit == secondToLastFruit) {
                currentMax++;
            } else {
                currentMax = lastFruitCount + 1;
            }

            // Evaluate last fruit count
            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
            }

            // Evaluate last and second to last
            if (fruit != lastFruit) {
                secondToLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currentMax);

        }

        return max;
    }

    static int total(int[] tree) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        int traverse = 0;
        TreeMap<Integer, Integer> lastIndexOf = new TreeMap<>();
        while (traverse < tree.length) {

            if (lastIndexOf.size() < 2 || (lastIndexOf.size() == 2 && lastIndexOf.containsKey(tree[traverse]))) {
                lastIndexOf.put(tree[traverse], traverse);
                total++;
                traverse++;
            } else if (lastIndexOf.size() == 2 && !lastIndexOf.containsKey(tree[traverse])) {
                lastIndexOf.remove(tree[traverse - 1]);
                traverse = lastIndexOf.firstEntry().getValue() + 1;
                lastIndexOf.clear();
                lastIndexOf.put(tree[traverse], traverse);
                max = Math.max(max, total);
                total = 0;
            }
        }

        return Math.max(total, max);
    }

    public static void main(String[] args) {
        System.out.println(total(new int[]{1, 2, 1}));
        System.out.println(total(new int[]{0, 1, 2, 2}));
        System.out.println(total(new int[]{1, 2, 3, 2, 2}));
        System.out.println(total(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(total(new int[]{0, 1, 6, 6, 4, 4, 6}));

        System.out.println("=========================");

        System.out.println(betterSpaceComplexity(new int[]{1, 2, 1}));
        System.out.println(betterSpaceComplexity(new int[]{0, 1, 2, 2}));
        System.out.println(betterSpaceComplexity(new int[]{1, 2, 3, 2, 2}));
        System.out.println(betterSpaceComplexity(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(betterSpaceComplexity(new int[]{0, 1, 6, 6, 4, 4, 6}));
    }

}
