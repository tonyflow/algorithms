package leetcode.topkfrequentelements;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] numbers = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(numbers, 2)));
    }
}
