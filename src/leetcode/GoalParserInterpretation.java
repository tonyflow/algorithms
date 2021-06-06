package leetcode;

import java.util.HashMap;

public class GoalParserInterpretation {

    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        HashMap<String, String> mapping = new HashMap<>();
        mapping.put("G", "G");
        mapping.put("()", "o");
        mapping.put("(al)", "al");

        char[] chars = command.toCharArray();
        int current = 0;

        while (current < chars.length) {
            if (chars[current] == 'G') {
                builder.append(mapping.get(Character.toString(chars[current])));
            } else if (chars[current] == '(') {
                StringBuilder parenthesisCommandBuilder = new StringBuilder();
                parenthesisCommandBuilder.append(chars[current]);
                while (chars[current] != ')') {
                    current++;
                    parenthesisCommandBuilder.append(chars[current]);
                }
                builder.append(mapping.get(parenthesisCommandBuilder.toString()));
            }
            current++;
        }

        return builder.toString();
    }
}
