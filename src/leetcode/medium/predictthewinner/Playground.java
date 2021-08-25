package leetcode.medium.predictthewinner;

public class Playground {

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        int[] test = {1, 5, 2};
        int[] b = {1, 5, 233, 7};
        System.out.println(predictTheWinner.predict(test));
        System.out.println(predictTheWinner.predict(b));
    }
}
