package leetcode.medium;

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwaps(String s) {

        Stack<Character> stack = new Stack();
        int unbalanced = s.length();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(c);
            else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
                unbalanced -= 2;
            }
        }

        int numberOfPairs = unbalanced / 2;
        return (numberOfPairs + 1) / 2;
    }
}
