package leetcode;

import java.util.Stack;

public class MakeTheStringGreat {

    static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() - 32 == c || c - 32 == stack.peek())) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("leEeetcode"));
    }
}
