package leetcode.hard.expressionaddoperators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionAddOperators {

    char[] operators = {'+', '-', '*'};

    public List<String> addOperators(String num, int target) {

        Set<String> result = new HashSet();
        doAdd(num, 0, 1, null, 0, '+', new StringBuilder(), target, result);
        return new ArrayList(result);
    }

    private void doAdd(String num,
                       int index,
                       long factor,
                       Character opBeforeMultiplication,
                       long path,
                       char operator,
                       StringBuilder expression,
                       int target,
                       Set<String> result) {

        if (index == num.length()) {
            if (opBeforeMultiplication != null) {
                // times 1 to understand that this is the "additional" of the following loop
                if (opBeforeMultiplication == '+') path += factor * 1;
                else path -= factor * 1;
            }
            if (path == target &&
                    (expression.toString().contains("-") || expression.toString().contains("+") || expression.toString().contains("*"))) {
                StringBuilder partial = new StringBuilder(expression);
                partial.deleteCharAt(partial.length() - 1);
                result.add(partial.toString());
                System.out.println(expression);
            }
            return;
        }

        // num.length() - 2 since we need at least one binary operator to form an expression
        // so, we need at least 2 numbers for which the operator can work on
        StringBuilder candidateNumber = new StringBuilder();
        for (int i = index; i < num.length(); i++) {
            candidateNumber.append(num.charAt(i));

            // Checks about the candidate number
            if (candidateNumber.charAt(0) == '0' && candidateNumber.length() > 1) break;
            long additional = Long.parseLong(candidateNumber.toString());
            expression.append(num.charAt(i));
            for (char o : operators) {
                expression.append(o);
                if (operator == '+') {
                    // preceding character is + and succeeding character is *
                    if (o == '*') {
                        doAdd(num, i + 1, factor * additional, '+', path, o, expression, target, result);
                    } else {
                        // preceding character is + and succeeding character is - or +
                        doAdd(num, i + 1, 1, opBeforeMultiplication, path + factor * additional, o, expression, target, result);
                    }
                } else if (operator == '-') {
                    // preceding character is - and succeeding character is *
                    if (o == '*') {
                        doAdd(num, i + 1, factor * additional, '-', path, o, expression, target, result);
                    } else {
                        // preceding character is - and succeeding character is - or +
                        doAdd(num, i + 1, 1, opBeforeMultiplication, path - factor * additional, o, expression, target, result);
                    }
                } else {
                    // preceding character is * and succeeding character is *
                    if (o == '*') {
                        doAdd(num, i + 1, factor * additional, opBeforeMultiplication, path, o, expression, target, result);
                    } else {
                        // preceding character is * and succeeding character is - or +
                        if (opBeforeMultiplication == '+') {
                            doAdd(num, i + 1, 1, null, path + factor * additional, o, expression, target, result);
                        } else {
                            doAdd(num, i + 1, 1, null, path - factor * additional, o, expression, target, result);
                        }
                    }
                }
                expression.deleteCharAt(expression.length() - 1);
            }
        }
        // backtrack
        // Remove all characters till we encounter a digit or the expression is empty
        while (expression.length() > 0 && Character.isDigit(expression.charAt(expression.length() - 1)))
            expression.deleteCharAt(expression.length() - 1);
    }
}
