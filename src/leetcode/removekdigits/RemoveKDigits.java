package leetcode.removekdigits;

import java.util.Stack;

public class RemoveKDigits {

    static String remove(String num, int k) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            if (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        int leadingZerosIndex = 0;
        while (result.charAt(leadingZerosIndex) == '0') {
            result.deleteCharAt(leadingZerosIndex);
            leadingZerosIndex++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("1432219", 3));
    }
}
