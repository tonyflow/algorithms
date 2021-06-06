package leetcode.searchinrotatedsortedarray;

public class FindInCircularArray {

    static int find(int[] r, int target) {

        int low = 0;
        int high = r.length - 1;

        // Find point of shift
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (r[mid] > r[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int start;
        if (target >= r[low] && target <= r[r.length - 1]) {
            start = low;
            high = r.length - 1;
        } else {
            start = 0;
            high = low;
        }

        while (start <= high) {
            int mid = (high - start) / 2 + start;
            if (target > r[mid]) {
                start = mid + 1;
            } else if (target < r[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] r = new int[]{8, 9, 0, 1, 4, 6, 7};
//        System.out.println(FindInCircularArray.find(r,10));
//        System.out.println(FindInCircularArray.find(r,1));
//        System.out.println(FindInCircularArray.find(r,2));
//        System.out.println(FindInCircularArray.find(r, 9));
//        System.out.println(FindInCircularArray.find(r, 0));
//        System.out.println(FindInCircularArray.find(r, 7));
        System.out.println(FindInCircularArray.find(new int[]{5,1,3}, 1));
    }
}
