package leetcode;

public class ExcelSheetColumnNumber {

    static int titleToNumber(String columnTitle) {
        StringBuilder builder = new StringBuilder();
        int result = 0;
        while (!columnTitle.isEmpty()) {
            char currentChar = columnTitle.charAt(0);
            result = 10 * result + (currentChar - 'A') % 25 + 1;

            if (columnTitle.length() > 1) {
                columnTitle = columnTitle.substring(1);
            } else {
                columnTitle = "";
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(titleToNumber("A"));
//        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}
