package leetcode;

public class LicenseKeyFormatting {

    static String format(String s, int k) {

        StringBuilder builder = new StringBuilder();


        int group = 0;

        int length = s.toCharArray().length;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != '-' && group < k) {
                builder.insert(0, s.charAt(i));
                group++;
            } else if (s.charAt(i) == '-') continue;

            if (group == k && i != 0) {
                builder.insert(0, "-");
                group = 0;
            }


        }

        return builder.length() > 0 && builder.charAt(0) == '-' ? builder.substring(1).toUpperCase() : builder.toString().toUpperCase();
    }

    static String format2(String s, int k) {
        String reformatted = s.toUpperCase().replace("-", "");
        StringBuilder builder = new StringBuilder();
        int length = reformatted.length();

        int group = 0;

        for (int i = length - 1; i >= 0; i--) {
            if (group < k) {
                builder.insert(0, reformatted.charAt(i));
                group++;
            }

            if (group == k) {
                builder.insert(0, "-");
                group = 0;
            }
        }

        return builder.length() > 0 && builder.charAt(0) == '-' ? builder.substring(1).toUpperCase() : builder.toString().toUpperCase();
    }

    static String format3(String s, int k) {
        String reformatted = s.toUpperCase().replace("-", "");
        StringBuilder builder = new StringBuilder(reformatted);
        int length = reformatted.length();

        for (int i = length - k; i > 0; i = i - k) {
            System.out.println("i=" + i + ", char at i " + builder.charAt(i));
            builder.insert(i, "-");
            System.out.println("char at i " + builder.charAt(i));
        }

        return builder.toString();
    }


    public static void main(String[] args) {
//        System.out.println(format("2-5g-3-j", 2));
//        System.out.println(format("5F3Z-2e-9-w", 4));
//        System.out.println(format("--a-a-a-a--", 2));
//
//        System.out.println(format2("2-5g-3-j", 2));
//        System.out.println(format2("5F3Z-2e-9-w", 4));
//        System.out.println(format2("--a-a-a-a--", 2));
//        System.out.println(format2("----", 2));

        System.out.println(format3("2-5g-3-j", 2));
        System.out.println(format3("5F3Z-2e-9-w", 4));
        System.out.println(format3("--a-a-a-a--", 2));
        System.out.println(format3("----", 2));
    }
}
