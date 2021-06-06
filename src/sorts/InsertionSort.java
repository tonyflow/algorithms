package sorts;

/**
 * Items can move in the array only one space at a time
 */
public class InsertionSort extends Sort {

    @Override
    public void sort(int[] r) {
        for (int i = 1; i < r.length; i++) {
            for (int j = i; j > 0 && r[j] < r[j - 1]; j--) {
                swap(r, j, j - 1);
            }
        }
    }
}
