package februaryreset.mergesort;

public class MergeSort {

    int[] aux;

    void sort(int[] r) {
        aux = new int[r.length + 1];
        doSort2(r, 0, r.length - 1);
    }

    private void doSort(int[] r, int low, int high) {
        if (high > low) {
            int middle = (high - low) / 2 + low;
            doSort(r, low, middle);
            doSort(r, middle + 1, high);
            merge(r, low, middle, high);
        }
    }

    private void merge(int[] r,
                       int low,
                       int middle,
                       int high) {

        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) aux[k] = r[k];
        for (int k = low; k <= high; k++) {
            if (i > middle) r[k] = aux[j++];
            else if (j > high) r[k] = aux[i++];
            else if (aux[i] > aux[j]) r[k] = aux[i++];
            else r[k] = aux[j++];
        }
    }

    private void doSort2(int[] r, int low, int high) {
        if (high > low) {
            int middle = (high - low) / 2 + low;
            doSort2(r, low, middle);
            doSort2(r, middle + 1, high);
            merge2(r, low, middle, high);
        }
    }

    private void merge2(int[] r,
                        int low,
                        int middle,
                        int high) {
        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = r[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > middle) r[k] = aux[j++];
            else if (j > high) r[k] = aux[i++];
            else if (aux[i] > aux[j]) r[k] = aux[i++];
            else r[k] = aux[j++];
        }
    }
}
