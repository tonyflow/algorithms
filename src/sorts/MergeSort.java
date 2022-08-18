package sorts;

public class    MergeSort extends Sort {

    int[] aux;

    @Override
    public void sort(int[] r) {
        aux = new int[r.length + 1];
        doSort(r, 0, r.length - 1);
    }

    private void doSort(int[] r,
                        int low,
                        int high) {

        if (high > low) {
            int mid = (high - low) / 2 + low;
            doSort(r, low, mid);
            doSort(r, mid + 1, high);

            merge(r, low, mid, high);
        }

    }

    private void merge(int[] r,
                       int low,
                       int mid,
                       int high) {

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = r[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) r[k] = aux[j++];
            else if (j > high) r[k] = aux[i++];
            else if (aux[j] < aux[i]) r[k] = aux[j++];
            else r[k] = aux[i++];

        }


    }
}
