package leetcode.removekdigits;


import java.util.Stack;

public class Recap {

    static public String removeKdigits(String num, int k) {

        if (k >= 1 && num.length() == 1) return "0";

        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < num.toCharArray().length; i++) {
            int number = Character.getNumericValue(num.charAt(i));
            while (!stack.isEmpty() && stack.peek() > number && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(number);
        }

        // In case all elements are already in increasing order
        // Then we need to remove k digits from the end of the number
        while (k > 0) {
            stack.pop();
            k--;
        }


        while (!stack.isEmpty())
            builder.append(stack.pop());

        StringBuilder reversed = builder.reverse();

        // Delete leading zeroes
        while (reversed.length() > 1 && reversed.charAt(0) == '0')
            reversed.deleteCharAt(0);

        return reversed.length() > 0 ? reversed.toString() : "0";

    }

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10200", 1));
//        System.out.println(removeKdigits("9", 1));
//        System.out.println(removeKdigits("0", 1));
//        System.out.println(removeKdigits("112", 1));
        System.out.println(removeKdigits("10", 1));
    }
}
