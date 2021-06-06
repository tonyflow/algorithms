package sorts;

abstract class Sort {

    public abstract void sort(int[] r);

    void swap(int[] r, int i, int j) {
        int tmp = r[i];
        r[i] = r[j];
        r[j] = tmp;
    }
}
