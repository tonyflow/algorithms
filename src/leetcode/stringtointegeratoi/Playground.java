package leetcode.stringtointegeratoi;

public class Playground {

    public static void main(String[] args) {
        for (int i = Integer.MAX_VALUE; i > 1; i /= 10) {
            System.out.println(i);
            System.out.println(i%10);
        }
    }
}
