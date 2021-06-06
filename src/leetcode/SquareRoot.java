package leetcode;

public class SquareRoot {

    static int compute(int num) {

        if (num == 1 || num == 0) return num;

        int start = 1;
        int end = num;

        while (start < end) {
            int middle = (start + end+1) >>> 1; // perfect middle evaluation
            if (middle == num / middle) {
                return middle;
            } else if (middle > num / middle) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(compute(2147395599));
//        System.out.println(Integer.MAX_VALUE);
    }
}
