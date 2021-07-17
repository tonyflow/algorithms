package leetcode.zigzagconversion;

import java.util.ArrayList;
import java.util.List;

public class Recap {

    static public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> keeper = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            keeper.add(new StringBuilder());
        }

        for (int i = 0; i < s.toCharArray().length; i += numRows + 1) {
            for (int j = 0; j < numRows; j++) {
                keeper.get(i + j).append(s.charAt(i + j));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : keeper) {
            result.append(builder);
        }

        return result.toString();
    }

    static public String convertBad(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> keeper = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            keeper.add(new StringBuilder());
        }

        boolean goingDown = true;
        boolean goingUp = false;
        int current = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            keeper.get(current).append(s.charAt(i));
            if (goingDown && current == numRows - 1) {
                goingDown = false;
                goingUp = true;
                current--;
            } else if (goingDown && current < numRows - 1) {
                current++;
            } else if (goingUp && current == 0) {
                goingUp = false;
                goingDown = true;
                current++;
            } else if (goingUp && current > 0) {
                current--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : keeper) {
            result.append(builder);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
