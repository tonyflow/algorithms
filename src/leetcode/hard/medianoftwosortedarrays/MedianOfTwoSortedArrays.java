package leetcode.hard.medianoftwosortedarrays;

public class MedianOfTwoSortedArrays {

    /**
     * This assumes that partition X and partition Y are the last elements of the left half of the arrays after partitioned
     */
    public double findMedianSortedArraysDiffBSEnds(int[] nums1, int[] nums2) {

        int x = nums1.length;
        int y = nums2.length;
        int total = x + y;
        int half = total / 2;

        if (y < x) return findMedianSortedArraysDiffBSEnds(nums2, nums1);

        int startX = 0;
        int endX = x - 1;

        while (true) {
            int partitionX = startX + endX >>> 1;
            int partitionY = half - partitionX - 2;// since A and B are zero indexed

            int maxLeftX = partitionX >= 0 ? nums1[partitionX] : Integer.MIN_VALUE;
            int minRightX = partitionX + 1 < x ? nums1[partitionX + 1] : Integer.MAX_VALUE;
            int maxLeftY = partitionY >= 0 ? nums2[partitionY] : Integer.MIN_VALUE;
            int minRightY = partitionY + 1 < y ? nums2[partitionY + 1] : Integer.MAX_VALUE;

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                endX = partitionX - 1;
            } else {
                startX = partitionX + 1;
            }
        }
    }

    /**
     * This assumes that partition X and partition Y are the first elements of the right half of the arrays after partitioned
     * - Video explanation: https://www.youtube.com/watch?v=LPFhl65R7ww&t=1217s
     * - Code: https://github.com/neetcode-gh/leetcode/blob/main/4-median-of-two-sorted-arrays.py
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int x = nums1.length;
        int y = nums2.length;


        /*
        The solution assumes that partition X and partition Y are the first elements of the right half of the arrays after partitioned
        we are choosing the array with the least elements to do BS on since we want the condition (x + y) / 2 - partitionX
        to be positive and more specifically 0 <= partitionY <= y. If x<=y this is guaranteed.
        Before going into explaining this though we must first understand why we are partitioning y in (x + y + 1) / 2 - partitionX
        The plus one in this case is the trick.
        If we are processing an even number of elements (x+y % 2 == 0) then the median is avg(max(maxLeftX,maxLeftY),min(minRightX,minRightY))
        If we are processing an odd number of elements (x+y % 2 != 0) then we have to decide in which of the two halves of the merged array
        the median resides. We agree - by the solution's design - to partition the elements in such a way that the median resides on the LEFT
        part of the partition for odd number of elements. To do this we increase the formula
        partitionY = (x + y) / 2 - partitionX becomes
        partitionY = (x + y + 1) / 2 - partitionX
        For example let's say that we have arrays A = [1,2,3] and B = [4,5]
        The merged array  is [1,2,3,4,5] so we want
        - three elements from A on the left half and 0 elements of B on the left half
        - zero elements of A on the right half and 2 elements of B on the right half
        to do this partitionX = 3 (start of second half is empty) and partitionY = 0 start of second half is the start of the array
        if we use the formula partitionY = (x + y) / 2 - partitionX = (2+3)/2-3 = 2-3 = -1 so we need
        partitionY = (x + y + 1) / 2 - partitionX = (2+3+1)/2-3 = 6/2-3 = 0 to get the right result
        we should notice here that for even number of elements `(x + y) / 2 - partitionX = (x + y + 1) / 2 - partitionX`
        For example (2+4)/2-1 = 6/2-1 = 3-1 and
        (2+4+1)/2-1 = 7/2 - 1 = 3-1 so we can safely use partitionY = (x + y + 1) / 2 - partitionX for both odd and even number of elements
        In the beginning we mentioned that partitionX and partitionY are the first elements of the right half of the partition.
        Let's say now that we have A = [1,2,3] and B = [4,5,6]
        x + y = 6 % 2 == 0
        in that case the median should be (3 + 4)/2 = 6.5
        The correct partition that produces this median is
        - 3 elements from A on the left half and zero elements of B on the left half
        - 0 elements of A on the right half and 3 elements of B on the right half
        This means partitionX = x = 3 and partitionY = 0
        using this formula partitionY = (x + y + 1) / 2 - partitionX = (3+3+1)/2 - 3 = 7/2-3 = 3-3 = 0 which confirms
        our hypothesis

        Note: We always want this formula partitionY = (x + y + 1) / 2 - partitionX to produce positive results, to guarantee that
        we choose X as the smaller array of the two

        This comment is very informative about the entire process

        Small arrays like A = [1,3] and b = [2]
         */


        if (x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // The ends represent the number of elements that we can choose from array X
        int startX = 0;
        int endX = x;

        while (startX <= endX) {
            int partitionX = startX + endX >>> 1;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    // even number of elements in concatenation
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else {
                    // odd number of elements in concatenation
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                endX = partitionX - 1;
            } else {
                startX = partitionX + 1;
            }
        }

        return 0.0;
    }
}
