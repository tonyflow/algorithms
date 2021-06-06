package leetcode;

public class ValidPerfectSquare {
    static boolean isPerfectSquare(int num) {

        if (num == 1 || num == 0) return true;

        int start = 1;
        int end = num;

        while (start < end) {
            int middle = (start + end + 1) >>> 1; // perfect middle evaluation
            if (middle == num / middle) {
                return middle * middle == num;
            } else if (middle > num / middle) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }
        return start * start == num;
    }

    public static void main(String[] args) {
//        System.out.println(isPerfectSquare(4)); // 2
//        System.out.println("End ==============");
        System.out.println(isPerfectSquare(2147483647)); // 2
        System.out.println("End ==============");
//        System.out.println(isPerfectSquare(3)); // 1
//        System.out.println("End ==============");
//        System.out.println(isPerfectSquare(6)); // 2
//        System.out.println("End ==============");
//        System.out.println(isPerfectSquare(2147483647)); // ?
    }
}
