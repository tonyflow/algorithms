package geeksforgeeks.LengthOfUnsortedSubarray;

import java.util.Arrays;

public class LengthOfUnsortedSubarray {

    int[] printUnsorted(int[] arr, int n) {
        int start = 0;
        int end = 0;

        // 10,12,20,30,25,40,32,31,35,50,60

        // Find start
        // Find the first pair which should be swapped
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        }

        // Find the end
        // Find the first pair which should be swapped
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i - 1] > arr[i]) {
                end = i;
                break;
            }
        }

        // Find min and max of elements between start and end
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println(min);
        System.out.println(max);


        // Search between (0,s-1) for the first element larger than min
        for (int i = 0; i < n; i++) {
            if (arr[i] > min) {
                start = i;
                break;
            }
        }

        // Search between (e+1,n-1) for the first element smaller than max
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < max) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    int[] linearithmic(int[] arr, int n) {
        int[] clone = Arrays.copyOf(arr, n);
        Arrays.sort(clone);
        int start = 0;
        int end = 0;

        // Find start
        for (int i = 0; i < n; i++) {
            if (clone[i] != arr[i]) {
                start = i;
                break;
            }
        }

        // Find end
        for (int i = n - 1; i >= 0; i--) {
            if (clone[i] != arr[i]) {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }

}
