package leetcode;

import java.util.Stack;

public class RemoveOuterMostParentheses {

    static String removeOuterParentheses(String S) {
        int depth = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (depth++ != 0) {
                    builder.append("(");
                }
            } else if (c == ')') {
                if (--depth != 0) {
                    builder.append(")");
                }

            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()(()))"));
    }

}
