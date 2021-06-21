package leetcode.perfectsquares;

public class Playground {

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        for (int i = 1; i <= 63; i++) {
            System.out.println("For " + i + " we need at least " + perfectSquares.numSquares(i) + " squares");
        }
    }
}
