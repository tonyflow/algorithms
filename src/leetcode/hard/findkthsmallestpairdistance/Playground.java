package leetcode.hard.findkthsmallestpairdistance;

public class Playground {

    public static void main(String[] args) {
        int start = 0;
        int end = 9;
        while (start < end) {
            int middle = (start + end) >>> 1;
            System.out.println("Between " + start + " and " + end + " with middle " + middle);
            start = middle + 1;
        }
    }
}
