package leetcode;

public class PeakIndexInMountainArray {

    static int find(int[] mountain) {

        for (int i = 1; i <= mountain.length - 2; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) return i;
        }

        return -1;
    }

    static int findBinary(int[] mountain) {
        int low = 0;
        int high = mountain.length - 1;

        // 0   1   2    3   4   5   6   7   8   9
        // 24, 69, 100, 99, 79, 78, 67, 36, 26, 19

        // 0 1 2 3 4 5 4 3 2 1 0

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mountain[mid]<mountain[mid+1] && mountain[mid]>mountain[mid-1]) {
                low=mid+1;
            } else if(mountain[mid]>mountain[mid+1] && mountain[mid]<mountain[mid-1]){
                high=mid-1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(find(new int[]{3, 4, 5, 1}));
        System.out.println(find(new int[]{0, 10, 5, 2}));

        System.out.println(findBinary(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(findBinary(new int[]{3, 4, 5, 1}));
        System.out.println(findBinary(new int[]{0, 10, 5, 2}));
    }
}
