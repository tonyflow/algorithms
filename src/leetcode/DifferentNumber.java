package leetcode;

/**
 * This was a question asked during a PRAMP interview
 */
public class DifferentNumber {

    static int getDifferentNumber3(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr.length) {
                int tmp = arr[i];
                arr[i] = arr[arr[i]];
                arr[tmp] = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) return i;
        }

        return arr.length;

    }

    public static void main(String[] args) {
        System.out.println(getDifferentNumber3(new int[]{2, 1, 0, 4}));
    }


}
