package leetcode.evaluatedivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));

        evaluateDivision.calcEquation(equations, values, queries);
    }
}
