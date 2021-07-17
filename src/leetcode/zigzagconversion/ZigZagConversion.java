package leetcode.zigzagconversion;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    static String convert(String s, int numRows) {

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingUp = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == numRows - 1 && !goingUp) {
                currRow --;
                goingUp = true;
            } else if (currRow == 0 && goingUp) {
                currRow ++;
                goingUp = false;
            } else if (goingUp) currRow--;
            else currRow++;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row.toString());
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String zig = ZigZagConversion.convert("PAYPALISHIRING", 3);
        System.out.println(zig);
    }
}
