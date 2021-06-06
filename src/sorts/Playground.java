package sorts;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        int[] r = {45, 3, 24, 5, 6, 457, 0, 11};
        int[] a = {45, 3, 24, 5};

//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.sort(r);
//        System.out.println(Arrays.toString(r));

//        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.sort(r);
//        System.out.println(Arrays.toString(r));
//
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(r);
//        System.out.println(Arrays.toString(r));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(r);
        System.out.println(Arrays.toString(r));
    }


}
