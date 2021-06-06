package leetcode;

/**
 * Revisit when working on bit manipulation
 */
public class ExcelSheetColumnTitle {

    static String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            builder.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }

}
