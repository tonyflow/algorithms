package februaryreset;

import java.util.Arrays;

public class FirstAndLastOccurence {

    static int[] find(int[] r, int target) {
        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = r.length - 1;

        // Find first
        while (start < end) {
            int middle = (start + end) >>> 1;
            if (r[middle] >= target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        result[0] = start;

        // Find last
        start = 0;
        end = r.length - 1;
        while (start < end) {
            int middle = (start + end + 1) >>> 1;
            if (r[middle] <= target) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        int[] r = new int[]{1, 1, 1, 2, 2, 4, 5, 7};
        System.out.println(Arrays.toString(find(r, 2)));
    }


}
