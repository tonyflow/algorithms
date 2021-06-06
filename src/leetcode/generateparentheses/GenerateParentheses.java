package leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        Set<String> results = new HashSet<>();
        tle(n, builder, 0, results);
        return new ArrayList<>(results);
    }

    private void generate(int n,
                          StringBuilder builder,
                          int insertionPosition,
                          Set<String> results) {

    }

    private void tle(int n,
                     StringBuilder builder,
                     int insertionPosition,
                     Set<String> results) {
        if (n == 0) results.add(builder.toString());
        else {
            builder.insert(insertionPosition, "()");
            String resultSoFar = builder.toString();
            for (int i = 0; i < resultSoFar.length(); i++) {
                if (resultSoFar.charAt(i) == '(') {
                    tle(n - 1, new StringBuilder(resultSoFar), i, results);
                    tle(n - 1, new StringBuilder(resultSoFar), i + 1, results);
                }
            }
            tle(n - 1, new StringBuilder(builder), resultSoFar.length(), results); // after
        }

    }
}
