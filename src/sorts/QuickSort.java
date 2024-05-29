package sorts;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.copyOfRange;

public class QuickSort extends Sort {

    @Override
    public void sort(int[] r) {
        doSort(r, 0, r.length - 1);
    }

    private void doSort(int[] r,
                        int low,
                        int high) {

        if (high > low) {
            int p = partition(r, low, high);
            doSort(r, low, p - 1);
            doSort(r, p + 1, high);
        }
    }

    private int partition(int[] r,
                          int low,
                          int high) {

        int i = low;
        int j = high + 1;

        while (true) {
            while (r[low] > r[++i]) if (i == high) break;
            while (r[low] < r[--j]) if (j == low) break;
            if (i >= j) break;
            swap(r, i, j);
        }
        swap(r, low, j);

        return j;
    }

    private static AtomicInteger numberOfPartition = new AtomicInteger(0);

    int lomutoPartition(int[] A, int low, int high) {

        int i = low;
        int pivot = A[high];

        System.out
                .println("============================================================================");
        System.out.println("Handling subarray "
                + Arrays.toString(copyOfRange(A, low, high + 1)));
        System.out.println("Inside partition number "
                + numberOfPartition.getAndIncrement() + " where low = " + low
                + " and high = " + high);
        System.out.println("Pivot element is element residing on index " + high
                + " with value " + A[high]);

        for (int j = low; j < high; j++) {
            System.out.println("------------------------------ " + j
                    + " --------------------------------------");
            if (A[j] <= pivot) {
                System.out.println("Swapping elements : " + A[i] + " and "
                        + A[j] + " because ( " + A[j] + " <= " + pivot + " )");
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;

                System.out.println("After swap array is : "
                        + Arrays.toString(A));
                i++;
                System.out.println("i was incremented to " + i);
            } else {
                System.out.println(" ( " + A[j] + " > " + pivot + " )");
            }

        }

        System.out
                .println("Loop ended... Swapping pivot element with element at last value of index i");
        int tmp = A[high];
        A[high] = A[i];
        A[i] = tmp;
        System.out.println("After swap array is : " + Arrays.toString(A));
        System.out.println("Partition index is " + i);

        return i;
    }
}
