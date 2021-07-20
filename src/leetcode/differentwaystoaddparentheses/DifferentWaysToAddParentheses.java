package leetcode.differentwaystoaddparentheses;

import java.util.*;
import java.util.stream.Collectors;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.contains("*") || expression.contains("+") || expression.contains("-")) {
            List<Integer> partial = new ArrayList<>();
            for (int i = 0; i < expression.toCharArray().length; i++) {
                if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                    List<Integer> firstHalfResults = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> secondHalfResults = diffWaysToCompute(expression.substring(i + 1));

                    char operator = expression.charAt(i);
                    for (Integer firstHalfResult : firstHalfResults) {
                        for (Integer secondHalfResult : secondHalfResults) {
                            switch (operator) {
                                case '*':
                                    partial.add(firstHalfResult * secondHalfResult);
                                    break;
                                case '+':
                                    partial.add(firstHalfResult + secondHalfResult);
                                    break;
                                case '-':
                                    partial.add(firstHalfResult - secondHalfResult);
                                    break;
                            }
                        }
                    }

                }
            }
            return partial;
        } else {
            // parse number
            return Arrays.asList(Integer.parseInt(expression));
        }
    }


    public List<Integer> diffWaysToComputeFails(String expression) {
        Set<Integer> result = new HashSet<>();
        traverse(expression, 0, 1, "*", result);
        return result.stream().collect(Collectors.toList());
    }

    private void traverse(String expression,
                          int index,
                          int accumulator,
                          String operator,
                          Set<Integer> result) {
        if (index == expression.length()) {
            result.add(accumulator);
        } else {
            // find next pair of numbers and their operator between

            // Find first number
            StringBuilder builder = new StringBuilder();
            int current = index;
            while (current < expression.length() && expression.charAt(current) >= '0' && expression.charAt(current) <= '9') {
                builder.append(expression.charAt(current));
                current++;
            }
            int first = Integer.parseInt(builder.toString());

            // Find operator after first
            String operatorAfterFirst = current < expression.length() ? Character.toString(expression.charAt(current++)) : null;
            int indexAfterFirstOperator = current;

            // Find second number
            builder = new StringBuilder();
            while (current < expression.length() && expression.charAt(current) >= '0' && expression.charAt(current) <= '9') {
                builder.append(expression.charAt(current));
                current++;
            }
            Integer second = builder.length() > 0 ? Integer.parseInt(builder.toString()) : null;

            // Find operator after second
            String operatorAfterSecond = current < expression.length() ? Character.toString(expression.charAt(current++)) : null;
            int indexAfterSecondOperator = current;

            // Find result pair
            Integer pair = null;
            if (operatorAfterFirst != null) {
                if (operatorAfterFirst != null && operatorAfterFirst.equals("*")) {
                    pair = first * second;
                } else if (operator.equals("+")) {
                    pair = first + second;
                } else {
                    pair = first - second;
                }
            }


            // Recursion
            if (operator.equals("*")) {
                traverse(expression, indexAfterFirstOperator, accumulator * first, operatorAfterFirst, result);
                if (pair != null)
                    traverse(expression, indexAfterSecondOperator, accumulator * pair, operatorAfterSecond, result);
            } else if (operator.equals("+")) {
                traverse(expression, indexAfterFirstOperator, accumulator + first, operatorAfterFirst, result);
                if (pair != null)
                    traverse(expression, indexAfterSecondOperator, accumulator + pair, operatorAfterSecond, result);
            } else {
                //operator.equals("-")
                traverse(expression, indexAfterFirstOperator, accumulator - first, operatorAfterFirst, result);
                if (pair != null)
                    traverse(expression, indexAfterSecondOperator, accumulator - pair, operatorAfterSecond, result);
            }
        }
    }
}
