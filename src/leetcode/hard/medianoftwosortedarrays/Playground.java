package leetcode.hard.medianoftwosortedarrays;

public class Playground {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArraysDiffBSEnds(a, b));
    }
}
