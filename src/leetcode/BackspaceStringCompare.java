package leetcode;

import java.util.Stack;

public class BackspaceStringCompare {

    boolean anotherSolution(String s, String t) {
        return process(s).equals(process(t));
    }

    String processFoo(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (c != '#') {
                stack.add(c);
            }
        }


        while (!stack.isEmpty()){
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }

    String process(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (c != '#') {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }

    static boolean compare(String a, String b) {
        return convert(a).equals(convert(b));
    }

    static private String convert(String a) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (stringBuilder.length() == 0 && a.charAt(i) == '#') continue;
            if (a.charAt(i) == '#') {
                int helper = i;
                int backspaces = 0;
                // Find number of backspaces
                while (a.charAt(helper) == '#' && helper < a.length()) {
                    backspaces++;
                    helper++;
                }
                for (int j = 0; j < backspaces && stringBuilder.length() > 0; j++) {
                    stringBuilder.deleteCharAt((stringBuilder.length()) - (j + 1));
                }
            } else {
                stringBuilder.append(a.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compare("a##c", "#a#c"));
    }
}
