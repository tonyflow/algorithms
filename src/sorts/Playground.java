package sorts;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        int[] r = {45, 3, 24, 5, 6, 457, 0, 11};
        int[] a = {45, 3, 24, 5};
        int[] c = {170, 45, 75, 90, 802, 24, 2, 66};


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

//        RadixSort radixSort = new RadixSort();
//        radixSort.sort(c);
//        G4GRadix g4GRadix = new G4GRadix();
//        g4GRadix.sort(c);
        System.out.println(Arrays.toString(c));
    }


}
