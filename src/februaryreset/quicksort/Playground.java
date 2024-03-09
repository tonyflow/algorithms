package februaryreset.quicksort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        int[] r = new int[]{45, 3, 24, 5, 6, 457, 0, 11};
        quickSort.sort(r);
        System.out.println(Arrays.toString(r));
    }
}
