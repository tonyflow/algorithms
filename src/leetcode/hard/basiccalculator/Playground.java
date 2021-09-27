package leetcode.hard.basiccalculator;

public class Playground {

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        // "(1+(4+5+2)-3)+(6+8)"
        //" 2-1 + 2 "
//        System.out.println(basicCalculator.calculate(" 1 - (-2) ")); // 3
//        System.out.println(basicCalculator.calculate("(1)")); // 1
        System.out.println(basicCalculator.calculate("1 + 1")); // 2
        System.out.println(basicCalculator.calculate(" 2-1 + 2 ")); // 3
//        System.out.println(basicCalculator.calculate("2-(5-6)")); // 3
//        System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)")); // 23
//        System.out.println(basicCalculator.calculate("0")); // 0
    }
}
