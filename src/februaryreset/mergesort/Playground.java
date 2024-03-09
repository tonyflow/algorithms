package februaryreset.mergesort;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] r = new int[]{44, 5, 66, 8, 89, 123};
        mergeSort.sort(r);
        System.out.println(Arrays.toString(r));
    }
}
