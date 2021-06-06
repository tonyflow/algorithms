package leetcode.searchinrotatedsortedarray;

public class SearchInRotatedSortedArray {

    //
    static int search(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length - 1;

        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (r[middle] > r[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        // On exit = start == end
        // This means that the pivot == start == end

        // Now we can choose the right side of the array and search it using BS again
        if (target <= r[r.length - 1]) {
            end = r.length - 1;
        } else {
            start = 0;
            end--;
        }

        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (r[middle] == target) {
                return middle;
            } else if (r[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] r = new int[]{8, 9, 0, 1, 4, 6, 7};
        int[] r = new int[]{5,1,3};
        int[] ra = new int[]{3, 1};

        System.out.println(search(r, 1));
        System.out.println(search(r, 3));
    }

}
