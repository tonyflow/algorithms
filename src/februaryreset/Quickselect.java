package februaryreset;

public class Quickselect {

    int select(int[] r, int k) {
        return doSelect(r, 0, r.length - 1, k - 1);
    }

    private int doSelect(int[] r,
                         int start,
                         int end,
                         int k) {
        if (start > end) return -1;

        int pivot = partition(r, start, end);

        if (pivot == k) return r[pivot];
        else if (pivot > k) {
            return doSelect(r, start, pivot - 1, k);
        } else {
            return doSelect(r, pivot + 1, end, k);
        }
    }

    private int partition(int[] r,
                          int start,
                          int end) {
        int pivot = r[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (pivot >= r[j]) {
                swap(r, i, j);
                i++;
            }
        }

        swap(r, i, end);
        return i;
    }

    private void swap(int[] r, int i, int j) {
        int tmp = r[i];
        r[i]=r[j];
    }
}
