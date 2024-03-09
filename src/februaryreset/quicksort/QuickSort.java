package februaryreset.quicksort;

public class QuickSort {

    void sort(int[] r) {
        doSort(r, 0, r.length - 1);
    }

    private void doSort(int[] r, int low, int high) {
        if (high > low) {
            int pivot = partition(r, low, high);
            doSort(r, low, pivot - 1);
            doSort(r, pivot + 1, high);
        }
    }

    private int partition(int[] r, int low, int high) {
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

    private void swap(int[] r, int i, int j) {
        int tmp = r[i];
        r[i] = r[j];
        r[j] = tmp;
    }
}
