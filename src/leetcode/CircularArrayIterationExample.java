package leetcode;

public class CircularArrayIterationExample {

    public static void main(String[] args) {

        int[] example = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < example.length; i++) {
            System.out.println("Iteration for i=" + i + ", and value " + example[i]);
            for (int j = i; j < example.length + i; j++) {
                int mod = j % example.length;
                System.out.println("Modulo is " + mod+". example["+mod+"] is " + example[mod]);
            }
            System.out.println();
            System.out.println("========================================");
        }

        for (int i = 0; i < 2*example.length; i++) {
            System.out.println(example[i% example.length]);
        }
    }
}
