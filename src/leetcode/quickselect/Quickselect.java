package leetcode.quickselect;

public class Quickselect {

    void selectTopK(int[] nums, int k) {
        topK(nums, 0, nums.length - 1, k);
    }

    /**
     * The Kth largest element is the N-k smallest. So it's the same implementation
     * with bottomK with different checks
     */
    private void topK(int[] nums,
                      int start,
                      int end,
                      int k) {
        if (start == end) return;
        int partitionIndex = partition(nums, start, end);

        if (partitionIndex > nums.length - k) {
            topK(nums, start, partitionIndex - 1, k);
        } else if (partitionIndex < nums.length - k) {
            topK(nums, partitionIndex + 1, end, k);
        } else return;
    }

    void selectBottomK(int[] nums, int k) {
        bottomK(nums, 0, nums.length - 1, k);
    }

    private void bottomK(int[] nums,
                         int start,
                         int end,
                         int k) {
        if (start == end) return;

        int partitionIndex = partition(nums, start, end);

        if (partitionIndex < k - 1) { // the array is zero indexed so we have to compare against k-1 NOT k
            bottomK(nums, partitionIndex + 1, end, k);
        } else if (partitionIndex > k - 1) { // the array is zero indexed so we have to compare against k-1 NOT k
            bottomK(nums, start, partitionIndex - 1, k);
        } else return;

    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j <= end - 1; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
