package leetcode;

import java.util.Arrays;

public class SquareOfSortedArrays {

    // [-4,-3,-2,0,1,2,3]
    public static int[] process(int[] r) {

        // Create result array
        int[] result = new int[r.length];
        int positiveIndex = 0;
        // Find first negative element
        while (positiveIndex < r.length && r[positiveIndex] < 0) positiveIndex++;

        int negativeIndex = positiveIndex - 1;
        int resultIndex = 0;
        while ((negativeIndex >= 0 || positiveIndex < r.length) && resultIndex < r.length) {
            if (negativeIndex < 0) {
                result[resultIndex] = r[positiveIndex] * r[positiveIndex];
                positiveIndex++;
            } else if (positiveIndex >= r.length) {
                result[resultIndex] = r[negativeIndex] * r[negativeIndex];
                negativeIndex--;
            } else {
                if (Math.abs(r[negativeIndex]) < r[positiveIndex]) {
                    result[resultIndex] = r[negativeIndex] * r[negativeIndex];
                    negativeIndex--;
                } else {
                    result[resultIndex] = r[positiveIndex] * r[positiveIndex];
                    positiveIndex++;
                }
            }
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {-4, -3, -2, 0, 1, 2, 3};
        System.out.println(Arrays.toString(process(ints)));
    }
}
