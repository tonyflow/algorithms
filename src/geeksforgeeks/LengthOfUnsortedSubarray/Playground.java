package geeksforgeeks.LengthOfUnsortedSubarray;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        LengthOfUnsortedSubarray lengthOfUnsortedSubarray = new LengthOfUnsortedSubarray();
        int[] a = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] b = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        System.out.println(Arrays.toString(lengthOfUnsortedSubarray.printUnsorted(a, a.length)));
        System.out.println(Arrays.toString(lengthOfUnsortedSubarray.printUnsorted(b, b.length)));
    }
}
