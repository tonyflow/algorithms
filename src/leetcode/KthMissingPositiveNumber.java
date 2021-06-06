package leetcode;

public class KthMissingPositiveNumber {


    /**
     * https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC%2B%2BPython-O(logN)
     * For the first numbers there are A[i-1]-1  numbers missing. So the question is converted to finding the maximum
     * i so that A[i]-i-1 < k
     * <p>
     * We are returning start + k because of this:
     * https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC++Python-O(logN)/810500
     * <p>
     * read carefully this explanation
     * <p>
     * This approach is mindblowingly brilliant
     */
    static int logarithmicSolution(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end + 1) >>> 1;
            if (arr[middle] - middle - 1 < k) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start + k;
    }

    static int findKthPositive(int[] arr, int k) {
        boolean[] exists = new boolean[10001];

        for (int i : arr) {
            exists[i] = true;
        }

        int current = 1;
        while (current < exists.length && k > 0) {
            if (!exists[current++]) k--;
        }

        return current;
    }

    public static void main(String[] args) {
//        findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        System.out.println(logarithmicSolution(new int[]{2, 3, 4, 7, 11}, 5));
    }

}
