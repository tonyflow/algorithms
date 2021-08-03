package leetcode.searchinrotatedsortedarray;

public class PrampVersion {

    static int shiftedArrSearch(int[] shiftArr, int num) {
        int start = 0;
        int end = shiftArr.length - 1;

        while (start < end) {
            int middle = start + end >>> 1;

            if (shiftArr[middle] > shiftArr[end])
                start = middle + 1;
            else
                end = middle;
        }

        // start of the shifted array
        int newStart;
        int newEnd;
        if (shiftArr[start] <= num && shiftArr[shiftArr.length - 1] >= num) {
            newStart = start;
            newEnd = shiftArr.length - 1;
        } else {
            newStart = 0;
            newEnd = start - 1;
        }

        while (newStart < newEnd) {
            int middle = newStart + newEnd >>> 1;
            if (shiftArr[middle] > num)
                newEnd = middle - 1;
            else if (shiftArr[middle] < num) {
                newStart = middle + 1;
            } else {
                return middle;
            }
        }

        if (shiftArr[newStart] == num) return newStart;
        else return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] a = new int[]{1, 2};
        System.out.println(shiftedArrSearch(a, 2));
    }
}
