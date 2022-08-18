package sorts;

import java.util.Arrays;

public class RadixSort extends Sort {

    @Override
    public void sort(int[] nums) {
        int max = getMax(nums);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(nums, nums.length, exp);
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, nums[i]);

        return max;
    }

    private void countSort(int[] nums, int n, int exp) {

        System.out.println("********** Count for exponent " + exp + " **********");
        int[] output = new int[n];
        int[] counts = new int[10];
        Arrays.fill(counts, 0);

        // count occurrences
        for (int i = 0; i < n; i++) {
            int index = (nums[i] / exp) % 10;
            counts[index]++;
        }

        System.out.println("Count array before aggregation " + Arrays.toString(counts));

        // make counts carry the indexes of the numbers in the output array. For example, if
        // the counts were (0,1,2,3,0,0,0,0,0,0) then this will create (0,1,3,6,6,6,6,6,6,6)
        // this means that that on the output array the numbers whose digit-under-process is 1
        // occupy the first place, then we have 2 numbers whose digit under process is 2 and we
        // will start inserting these numbers from index 3 of the output array and so on and so
        // forth
        for (int i = 1; i < 10; i++) {
            counts[i] += counts[i - 1];
        }
        System.out.println("Count array after aggregation " + Arrays.toString(counts));

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = (nums[i] / exp) % 10;
            output[counts[index] - 1] = nums[i];
            // since we have placed this element, there are n-1 elements to place for this digit
            counts[index]--;
        }
        System.out.println("Output array " + Arrays.toString(output));

        // Update the input array
        for (int i = 0; i < n; i++) {
            nums[i] = output[i];
        }
        System.out.println("********** End of processing for " + exp + " **********");
    }
}
