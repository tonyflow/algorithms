package sorts;

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
}
