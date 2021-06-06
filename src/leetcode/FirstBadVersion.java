package leetcode;

public class FirstBadVersion {

    static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int middle = (end + start) >>> 1;
            if (isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    static boolean isBadVersion(int version) {
        return version > 3;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(8));
    }
}
