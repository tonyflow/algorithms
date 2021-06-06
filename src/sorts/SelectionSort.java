package sorts;

public class SelectionSort extends Sort {

    @Override
    public void sort(int[] r) {
        for (int i = 0; i < r.length; i++) {
            for (int j = i + 1; j < r.length; j++) {
                if (r[i] < r[j]) {
                    swap(r, i, j);
                }
            }
        }
    }
}
