package leetcode.hard.maximumsumof3nonoverlappingsubarrays;

public class Playground {

    public static void main(String[] args) {
        MaximumSumOf3NonOverlappingSubarrays maximumSumOf3NonOverlappingSubarrays = new MaximumSumOf3NonOverlappingSubarrays();
        //nums = [1,2,1,2,6,7,5,1], k = 2
        int[] a = {1, 2, 1, 2, 6, 7, 5, 1};
        maximumSumOf3NonOverlappingSubarrays.maxSumOfThreeSubarrays(a, 2);
    }
}
