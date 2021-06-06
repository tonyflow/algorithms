package leetcode;

import java.util.Stack;

public class BalancedParentheses {

    boolean elastic_balancedParentheses(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')' && stack.isEmpty()) return false;
            else if (c == ')') stack.pop();
        }

        return stack.isEmpty();
    }
}
