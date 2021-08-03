package bitmanipulation;

public class PositionOfRightmostSetBit {

    public static void main(String[] args) {
        int n = 12; // 1 1 0 0
        int m = 1;
        int position = 0;
        while ((n & m) == 0) {
            position++;
            m <<= 1;
        }

        System.out.println(position);

    }
}
